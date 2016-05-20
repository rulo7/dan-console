/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package overriders.domain.repository;

import exceptions.DanKeyNotFoundException;
import java.io.IOException;
import overriders.SchemaOverrider;
import tools.PackagesProvider;
import tools.SchemasProvider;

/**
 *
 * @author raulcobos
 */
public class RepositorySchemaOverrider extends SchemaOverrider{

    @Override
    protected String getPackageName() throws IOException, DanKeyNotFoundException {
        return PackagesProvider.getRepositoryPackage();
    }

    @Override
    protected String getScheme() throws IOException, DanKeyNotFoundException {
        return SchemasProvider.getRepositorySchema();
    }
    
}
