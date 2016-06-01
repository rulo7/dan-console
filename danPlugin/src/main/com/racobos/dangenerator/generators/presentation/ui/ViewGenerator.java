package com.racobos.dangenerator.generators.presentation.ui;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.racobos.dangenerator.exceptions.DanKeyNotFoundException;
import com.racobos.dangenerator.generators.Generator;
import com.racobos.dangenerator.overriders.SchemaOverrider;
import com.racobos.dangenerator.overriders.presentation.ui.ViewSchemaOverrider;
import com.racobos.dangenerator.tools.FileManager;
import com.racobos.dangenerator.tools.PathsProvider;
import java.io.File;
import java.io.IOException;

/**
 * @author raulcobos
 */
public class ViewGenerator extends Generator {

    private String uiName;

    public ViewGenerator(String uiName) {
        this.uiName = uiName.substring(0, 1).toLowerCase() + uiName.substring(1);
    }

    @Override
    public SchemaOverrider getOverrider() {
        return new ViewSchemaOverrider(uiName);
    }

    @Override
    public String getClassPath() throws IOException, DanKeyNotFoundException {
        return PathsProvider.getViewPath() + uiName + "/views/";
    }

    @Override
    public String getPostFixClass() {
        return "View.java";
    }

    @Override
    protected File createClassFile(String viewName) throws IOException, DanKeyNotFoundException {
        return FileManager.createFile(getClassPath(),
                (viewName.substring(0, 1).toUpperCase() + viewName.substring(1)) + getPostFixClass());
    }
}
