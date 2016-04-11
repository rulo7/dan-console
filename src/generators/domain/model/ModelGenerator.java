/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generators.domain.model;

import exceptions.DanKeyNotFoundException;
import generators.Generator;
import java.io.IOException;
import overriders.SchemaOverrider;
import overriders.domain.model.ModelSchemaOverrider;
import tools.PathsProvider;

/**
 *
 * @author raulcobos
 */
public class ModelGenerator extends Generator{

    @Override
    public SchemaOverrider getOverrider() {
        return new ModelSchemaOverrider();
    }

    @Override
    public String getClassPath() throws IOException, DanKeyNotFoundException{
        return PathsProvider.getModelPath();
    }

    
    @Override
    public String getPostFixClass() {
        return ".java";
    }
}
