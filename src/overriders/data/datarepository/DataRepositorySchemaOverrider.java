/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package overriders.data.datarepository;

import exceptions.DanKeyNotFoundException;
import java.io.IOException;
import overriders.SchemaOverrider;
import tools.PackagesProvider;
import tools.SchemasProvider;

/**
 *
 * @author raulcobos
 */
public class DataRepositorySchemaOverrider extends SchemaOverrider{

    @Override
    protected String getPackageName() throws IOException, DanKeyNotFoundException {
        return PackagesProvider.getDataRepositoryPackage();
    }

    @Override
    protected String getScheme() throws IOException, DanKeyNotFoundException {
        return SchemasProvider.getDataRepositorySchema();
    }
    
}
