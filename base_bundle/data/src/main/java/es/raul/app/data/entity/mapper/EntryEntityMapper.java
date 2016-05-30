package es.raul.app.data.entity.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by raulcobos.
 */
public abstract class EntryEntityMapper<Model, Entity> {

    public abstract Model transform(Entity entity);

    public List<Model> transform(Collection<Entity> collection) {
        List<Model> list = new ArrayList<>();
        Model model;
        for (Entity entity : collection) {
            model = transform(entity);
            if (model != null) {
                list.add(model);
            }
        }
        return list;
    }
}
