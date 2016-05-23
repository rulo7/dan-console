package com.rcobos.dangenerator.generators.data.datarepository;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.rcobos.dangenerator.exceptions.DanKeyNotFoundException;
import com.rcobos.dangenerator.generators.Generator;
import com.rcobos.dangenerator.overriders.SchemaOverrider;
import com.rcobos.dangenerator.overriders.data.datarepository.DataRepositorySchemaOverrider;
import com.rcobos.dangenerator.tools.PathsProvider;
import java.io.IOException;


/**
 *
 * @author raulcobos
 */
public class DataRepositoryGenerator extends Generator {

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
