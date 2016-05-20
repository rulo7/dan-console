/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generators.data.datarepository;

import exceptions.DanKeyNotFoundException;
import generators.Generator;
import java.io.IOException;
import overriders.SchemaOverrider;
import overriders.data.datarepository.DataRepositorySchemaOverrider;
import tools.PathsProvider;

/**
 *
 * @author raulcobos
 */
public class DataRepositoryGenerator extends Generator{

    @Override
    public SchemaOverrider getOverrider() {
        return new DataRepositorySchemaOverrider();
    }

    @Override
    public String getClassPath() throws IOException, DanKeyNotFoundException {
        return PathsProvider.getDataRepositoryPath();
    }

    @Override
    public String getPostFixClass() {
        return "DataRepository.java";
    }
    
}
