package com.rcobos.dangenerator.generators.data.entity;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.rcobos.dangenerator.exceptions.DanKeyNotFoundException;
import com.rcobos.dangenerator.generators.Generator;
import com.rcobos.dangenerator.overriders.SchemaOverrider;
import com.rcobos.dangenerator.overriders.data.entity.EntitySchemaOverrider;
import com.rcobos.dangenerator.tools.PathsProvider;
import java.io.IOException;


/**
 *
 * @author raulcobos
 */
public class EntityGenerator extends Generator {

    @Override
    public SchemaOverrider getOverrider() {
        return new EntitySchemaOverrider();
    }

    @Override
    public String getClassPath() throws IOException, DanKeyNotFoundException {
        return PathsProvider.getEntityPath();
    }

    
    @Override
    public String getPostFixClass() {
        return "Entity.java";
    }
}
