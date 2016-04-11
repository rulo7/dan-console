/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generators.data.datastore.imp;

import exceptions.DanKeyNotFoundException;
import generators.Generator;
import java.io.IOException;
import overriders.SchemaOverrider;
import overriders.data.datastore.imp.CloudDataStoreSchemaOverrider;
import tools.PathsProvider;

/**
 *
 * @author raulcobos
 */
public class CloudDataStoreGenerator extends Generator{

    @Override
    public SchemaOverrider getOverrider() {
        return new CloudDataStoreSchemaOverrider();
    }

    @Override
    public String getClassPath() throws IOException, DanKeyNotFoundException{
        return PathsProvider.getDataStorePath();
    }

    
    @Override
    public String getPostFixClass() {
        return "CloudDataStore.java";
    }
}