/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generators.data.mapper;

import exceptions.DanKeyNotFoundException;
import generators.Generator;
import java.io.IOException;
import overriders.SchemaOverrider;
import overriders.data.mapper.MapperSchemaOverrider;
import tools.PathsProvider;

/**
 *
 * @author raulcobos
 */
public class MapperGenerator extends Generator{

    @Override
    public SchemaOverrider getOverrider() {
        return new MapperSchemaOverrider();
    }

    @Override
    public String getClassPath() throws IOException, DanKeyNotFoundException {
        return PathsProvider.getMapperPath();
    }

    @Override
    public String getPostFixClass() {
        return "Mapper.java";
    }

}
