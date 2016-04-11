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
import overriders.data.datastore.imp.DiskDataStoreSchemaOverrider;
import tools.PathsProvider;

/**
 *
 * @author raulcobos
 */
public class DiskDataStoreGenerator extends Generator{

    @Override
    public SchemaOverrider getOverrider() {
        return new DiskDataStoreSchemaOverrider();
    }

    @Override
    public String getClassPath() throws IOException, DanKeyNotFoundException{
        return PathsProvider.getDataStorePath();
    }

    
    @Override
    public String getPostFixClass() {
        return "DiskDataStore.java";
    }
}