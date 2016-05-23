package com.rcobos.dangenerator.generators.data.mapper;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.rcobos.dangenerator.exceptions.DanKeyNotFoundException;
import com.rcobos.dangenerator.generators.Generator;
import com.rcobos.dangenerator.overriders.SchemaOverrider;
import com.rcobos.dangenerator.overriders.data.mapper.MapperSchemaOverrider;
import com.rcobos.dangenerator.tools.PathsProvider;
import java.io.IOException;


/**
 *
 * @author raulcobos
 */
public class MapperGenerator extends Generator {

    @Override
    public SchemaOverrider getOverrider() {
        return new MapperSchemaOverrider();
    }

    @Override
    public String getClassPath() throws IOException, DanKeyNotFoundException {
        return PathsProvider.getMapperPath();
    }

    @Override
    public String getPostFixClass() {
        return "Mapper.java";
    }

}
