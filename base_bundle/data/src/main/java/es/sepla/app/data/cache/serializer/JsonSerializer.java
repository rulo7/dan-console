/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package es.sepla.app.data.cache.serializer;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Class user as Serializer/Deserializer for user entities.
 */
public class JsonSerializer<T> {

    private final Gson gson = new Gson();

    Class<T> classObject;

    public JsonSerializer(Class<T> typeParamter) {
        classObject = typeParamter;
    }

    public String serialize(T entity) {
        return gson.toJson(entity, classObject);
    }

    public T deserialize(String jsonString) {
        return gson.fromJson(jsonString, classObject);
    }

    public List<T> deserializeList(String jsonString) {
        JsonParser parser = new JsonParser();
        JsonArray array = parser.parse(jsonString).getAsJsonArray();
        List<T> lst = new ArrayList<T>();
        for (final JsonElement json : array) {
            T entity = gson.fromJson(json, classObject);
            lst.add(entity);
        }
        return lst;
    }

    public String serializeList(List<T> dataList) {
        Type listType = new TypeToken<ArrayList<T>>() {
        }.getType();
        return gson.toJson(dataList, listType);
    }
}
