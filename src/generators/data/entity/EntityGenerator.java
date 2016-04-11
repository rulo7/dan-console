/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generators.data.entity;

import exceptions.DanKeyNotFoundException;
import generators.Generator;
import java.io.IOException;
import overriders.SchemaOverrider;
import overriders.data.entity.EntitySchemaOverrider;
import tools.PathsProvider;

/**
 *
 * @author raulcobos
 */
public class EntityGenerator extends Generator{

    @Override
    public SchemaOverrider getOverrider() {
        return new EntitySchemaOverrider();
    }

    @Override
    public String getClassPath() throws IOException, DanKeyNotFoundException{
        return PathsProvider.getEntityPath();
    }

    
    @Override
    public String getPostFixClass() {
        return "Entity.java";
    }
}
