package com.racobos.dangenerator.generators.data.entity;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.racobos.dangenerator.exceptions.DanKeyNotFoundException;
import com.racobos.dangenerator.generators.Generator;
import com.racobos.dangenerator.overriders.SchemaOverrider;
import com.racobos.dangenerator.overriders.data.entity.EntitySchemaOverrider;
import com.racobos.dangenerator.tools.PathsProvider;
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
