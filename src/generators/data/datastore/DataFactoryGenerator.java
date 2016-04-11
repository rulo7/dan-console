/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generators.data.datastore;

import exceptions.DanKeyNotFoundException;
import generators.Generator;
import java.io.IOException;
import overriders.SchemaOverrider;
import overriders.data.datastore.imp.DataFactorySchemaOverrider;
import tools.PathsProvider;

/**
 *
 * @author raulcobos
 */
public class DataFactoryGenerator extends Generator{

    @Override
    public SchemaOverrider getOverrider() {
        return new DataFactorySchemaOverrider();
    }

    @Override
    public String getClassPath() throws IOException, DanKeyNotFoundException{
        return PathsProvider.getDataStorePath();
    }

    
    @Override
    public String getPostFixClass() {
        return "DataFactory.java";
    }
}
