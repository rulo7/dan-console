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

/**
 *
 * @author raulcobos
 */
public class RepositoryGenerator extends Generator{

    @Override
    public SchemaOverrider getOverrider() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getClassPath() throws IOException, DanKeyNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPostFixClass() {
        return "Repository.java";
    }
    
}
