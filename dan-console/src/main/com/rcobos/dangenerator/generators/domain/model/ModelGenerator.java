package com.rcobos.dangenerator.generators.domain.model;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.rcobos.dangenerator.exceptions.DanKeyNotFoundException;
import com.rcobos.dangenerator.generators.Generator;
import com.rcobos.dangenerator.overriders.SchemaOverrider;
import com.rcobos.dangenerator.overriders.domain.model.ModelSchemaOverrider;
import com.rcobos.dangenerator.tools.PathsProvider;
import java.io.IOException;

/**
 *
 * @author raulcobos
 */
public class ModelGenerator extends Generator {

    @Override
    public SchemaOverrider getOverrider() {
        return new ModelSchemaOverrider();
    }

    @Override
    public String getClassPath() throws IOException, DanKeyNotFoundException {
        return PathsProvider.getModelPath();
    }

    
    @Override
    public String getPostFixClass() {
        return ".java";
    }
}
