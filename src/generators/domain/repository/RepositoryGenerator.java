/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generators.domain.repository;

import exceptions.DanKeyNotFoundException;
import generators.Generator;
import java.io.IOException;
import overriders.SchemaOverrider;
import overriders.domain.repository.RepositorySchemaOverrider;
import tools.PathsProvider;

/**
 *
 * @author raulcobos
 */
public class RepositoryGenerator extends Generator{

    @Override
    public SchemaOverrider getOverrider() {
        return new RepositorySchemaOverrider();
    }

    @Override
    public String getClassPath() throws IOException, DanKeyNotFoundException {
        return PathsProvider.getRepositoryPath();
    }

    @Override
    public String getPostFixClass() {
        return "Repository.java";
    }
    
}
