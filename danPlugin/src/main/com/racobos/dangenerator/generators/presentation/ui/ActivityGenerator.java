package com.racobos.dangenerator.generators.presentation.ui;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.racobos.dangenerator.exceptions.DanKeyNotFoundException;
import com.racobos.dangenerator.generators.Generator;
import com.racobos.dangenerator.overriders.SchemaOverrider;
import com.racobos.dangenerator.overriders.presentation.ui.ActivitySchemaOverrider;
import com.racobos.dangenerator.tools.FileManager;
import com.racobos.dangenerator.tools.PathsProvider;
import java.io.File;
import java.io.IOException;

/**
 * @author raulcobos
 */
public class ActivityGenerator extends Generator {

    @Override
    public SchemaOverrider getOverrider() {
        return new ActivitySchemaOverrider();
    }

    @Override
    public String getClassPath() throws IOException, DanKeyNotFoundException {
        return PathsProvider.getActivityPath();
    }

    @Override
    public String getPostFixClass() {
        return "Activity.java";
    }

    @Override
    protected File createClassFile(String uiName) throws IOException, DanKeyNotFoundException {
        return FileManager.createFile(
                getClassPath() + (uiName.substring(0, 1).toLowerCase() + uiName.substring(1)) + File.separator,
                (uiName.substring(0, 1).toUpperCase() + uiName.substring(1)) + getPostFixClass());
    }
}
