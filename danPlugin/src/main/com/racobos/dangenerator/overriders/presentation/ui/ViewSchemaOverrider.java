package com.racobos.dangenerator.overriders.presentation.ui;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.racobos.dangenerator.exceptions.DanKeyNotFoundException;
import com.racobos.dangenerator.overriders.SchemaOverrider;
import com.racobos.dangenerator.tools.PackagesProvider;
import com.racobos.dangenerator.tools.SchemasProvider;
import java.io.IOException;

/**
 * @author raulcobos
 */
public class ViewSchemaOverrider extends SchemaOverrider {

    private String uiName;

    public ViewSchemaOverrider(String uiName) {
        this.uiName = uiName;
    }

    @Override
    protected String getPackageName() throws IOException, DanKeyNotFoundException {
        return PackagesProvider.getViewPackage();
    }

    @Override
    protected String getScheme() throws IOException, DanKeyNotFoundException {
        return SchemasProvider.getViewSchema();
    }

    @Override
    public String generateSchema(String viewName) throws IOException, DanKeyNotFoundException {
        final String UINAME_TAG = "_uiNamePackage_";
        return super.generateSchema(viewName).replace(UINAME_TAG, uiName);
    }
}
