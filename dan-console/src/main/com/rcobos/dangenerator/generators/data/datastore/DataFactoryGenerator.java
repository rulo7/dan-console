package com.rcobos.dangenerator.generators.data.datastore;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.rcobos.dangenerator.exceptions.DanKeyNotFoundException;
import com.rcobos.dangenerator.generators.Generator;
import com.rcobos.dangenerator.overriders.SchemaOverrider;
import com.rcobos.dangenerator.overriders.data.datastore.imp.DataFactorySchemaOverrider;
import com.rcobos.dangenerator.tools.PathsProvider;
import java.io.IOException;

/**
 * @author raulcobos
 */
public class DataFactoryGenerator extends Generator {

    @Override
    public SchemaOverrider getOverrider() {
        return new DataFactorySchemaOverrider();
    }

    @Override
    public String getClassPath() throws IOException, DanKeyNotFoundException {
        return PathsProvider.getDataStorePath();
    }

    @Override
    public String getPostFixClass() {
        return "DataFactory.java";
    }
}
