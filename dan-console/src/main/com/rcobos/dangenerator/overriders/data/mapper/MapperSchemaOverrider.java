package com.rcobos.dangenerator.overriders.data.mapper;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.rcobos.dangenerator.exceptions.DanKeyNotFoundException;
import com.rcobos.dangenerator.overriders.SchemaOverrider;
import com.rcobos.dangenerator.tools.PackagesProvider;
import com.rcobos.dangenerator.tools.SchemasProvider;
import java.io.IOException;


/**
 *
 * @author raulcobos
 */
public class MapperSchemaOverrider extends SchemaOverrider {

    @Override
    protected String getPackageName() throws IOException, DanKeyNotFoundException {
        return PackagesProvider.getMapperPackage();
    }

    @Override
    protected String getScheme() throws IOException, DanKeyNotFoundException {
        return SchemasProvider.getMapperSchema();
    }
    
}
