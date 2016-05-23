package com.racobos.dangenerator.generators.data.cache;

import com.racobos.dangenerator.exceptions.DanKeyNotFoundException;
import com.racobos.dangenerator.generators.Generator;
import com.racobos.dangenerator.overriders.SchemaOverrider;
import com.racobos.dangenerator.overriders.data.cache.CacheSchemaOverrider;
import com.racobos.dangenerator.tools.PathsProvider;
import java.io.IOException;


/**
 *
 * @author raulcobos
 */
public class CacheGenerator extends Generator {

    @Override
    public SchemaOverrider getOverrider() {
        return new CacheSchemaOverrider();
    }

    @Override
    public String getClassPath() throws IOException, DanKeyNotFoundException {
        return PathsProvider.getCachePath();
    }

    
    @Override
    public String getPostFixClass() {
        return "Cache.java";
    }
    
}