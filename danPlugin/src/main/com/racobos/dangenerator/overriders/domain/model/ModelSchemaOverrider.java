package com.racobos.dangenerator.overriders.domain.model;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.racobos.dangenerator.tools.PackagesProvider;
import com.racobos.dangenerator.exceptions.DanKeyNotFoundException;
import com.racobos.dangenerator.overriders.SchemaOverrider;
import com.racobos.dangenerator.tools.SchemasProvider;
import java.io.IOException;


/**
 *
 * @author raulcobos
 */
public class ModelSchemaOverrider extends SchemaOverrider {

    @Override
    protected String getPackageName() throws IOException, DanKeyNotFoundException {
        return PackagesProvider.getModelPackage();
    }

    @Override
    protected String getScheme() throws IOException, DanKeyNotFoundException {
        return SchemasProvider.getModelSchema();
    }
    
}
