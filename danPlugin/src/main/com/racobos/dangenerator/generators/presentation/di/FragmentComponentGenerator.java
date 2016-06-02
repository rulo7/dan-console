package com.racobos.dangenerator.generators.presentation.di;

import com.racobos.dangenerator.exceptions.DanKeyNotFoundException;
import com.racobos.dangenerator.generators.Generator;
import com.racobos.dangenerator.overriders.SchemaOverrider;
import com.racobos.dangenerator.overriders.presentation.di.FragmentComponentOverrider;
import com.racobos.dangenerator.tools.FileManager;
import com.racobos.dangenerator.tools.PackagesProvider;
import com.racobos.dangenerator.tools.PathsProvider;
import java.io.File;
import java.io.IOException;

/**
 * @author raulcobos
 */
public class FragmentComponentGenerator extends Generator {

    private String uiName;

    public FragmentComponentGenerator(String uiName) {
        this.uiName = uiName;
    }

    @Override
    public void generate(String viewName) {
        try {
            File f = FileManager.getFile(getClassPath(), getPostFixClass());
            if (!f.exists()) {
                super.generate(viewName);
            }
            addImportsAndInjections(viewName, f);
        } catch (IOException | DanKeyNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public SchemaOverrider getOverrider() {
        return new FragmentComponentOverrider();
    }

    @Override
    public String getClassPath() throws IOException, DanKeyNotFoundException {
        return PathsProvider.getFragmentComponentPath();
    }

    @Override
    public String getPostFixClass() {
        return "FragmentComponent.java";
    }

    @Override
    protected File createClassFile(String entityName) throws IOException, DanKeyNotFoundException {
        return FileManager.createFile(getClassPath(), getPostFixClass());
    }

    private void addImportsAndInjections(String viewName, File f) throws IOException, DanKeyNotFoundException {
        String readFile = FileManager.readFile(f);
        String modelClassName = viewName.substring(0, 1).toUpperCase() + viewName.substring(1) + "Fragment";
        String varName = viewName.substring(0, 1).toLowerCase() + viewName.substring(1) + "Fragment";
        String packageName = uiName.substring(0, 1).toLowerCase() + uiName.substring(1) + ".views";
        String importUiActivity = "import "
                + PackagesProvider.getAppPackage()
                + "."
                + PackagesProvider.getFragmentPackage()
                + "."
                + packageName
                + "."
                + modelClassName
                + ";";
        String provideUiFragment = "void inject (" + modelClassName + " " + varName + "); ";
        String completeClass = "";
        boolean imported = readFile.contains(importUiActivity);
        for (int i = 0; i < readFile.split(";").length; i++) {
            String fileLine = readFile.split(";")[i];
            if (fileLine.contains("import") && !imported) {
                completeClass += "\n" + importUiActivity;
                imported = true;
            }
            completeClass += fileLine + ";";
            if (i == readFile.split(";").length - 2 && !readFile.contains(provideUiFragment)) {
                completeClass += "\n\n    " + provideUiFragment;
            }
        }
        FileManager.writeFile(f, completeClass.substring(0, completeClass.length() - 1));
    }
}
