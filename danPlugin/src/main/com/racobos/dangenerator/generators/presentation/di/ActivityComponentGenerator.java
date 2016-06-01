package com.racobos.dangenerator.generators.presentation.di;

import com.racobos.dangenerator.exceptions.DanKeyNotFoundException;
import com.racobos.dangenerator.generators.Generator;
import com.racobos.dangenerator.overriders.SchemaOverrider;
import com.racobos.dangenerator.overriders.presentation.ui.ActivityComponentOverrider;
import com.racobos.dangenerator.tools.FileManager;
import com.racobos.dangenerator.tools.PackagesProvider;
import com.racobos.dangenerator.tools.PathsProvider;
import java.io.File;
import java.io.IOException;

/**
 * @author raulcobos
 */
public class ActivityComponentGenerator extends Generator {

    @Override
    public void generate(String uiName) {
        try {
            File f = FileManager.getFile(getClassPath(), getPostFixClass());
            if (!f.exists()) {
                super.generate(uiName);
            }
            addImportsAndInjections(uiName, f);
        } catch (IOException | DanKeyNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public SchemaOverrider getOverrider() {
        return new ActivityComponentOverrider();
    }

    @Override
    public String getClassPath() throws IOException, DanKeyNotFoundException {
        return PathsProvider.getActivityComponentPath();
    }

    @Override
    public String getPostFixClass() {
        return "ActivityComponent.java";
    }

    @Override
    protected File createClassFile(String entityName) throws IOException, DanKeyNotFoundException {
        return FileManager.createFile(getClassPath(), getPostFixClass());
    }

    private void addImportsAndInjections(String uiName, File f) throws IOException, DanKeyNotFoundException {
        String readFile = FileManager.readFile(f);
        String modelClassName = uiName.substring(0, 1).toUpperCase() + uiName.substring(1);
        String packageName = uiName.substring(0, 1).toLowerCase() + uiName.substring(1);
        String importUiActivity = "import "
                + PackagesProvider.getAppPackage()
                + "."
                + PackagesProvider.getActivityPackage()
                + "."
                + packageName
                + "."
                + modelClassName
                + "Activity;";
        String provideUiActivity = "void inject (" + modelClassName + "Activity " + packageName + "); ";
        String completeClass = "";
        boolean imported = false;
        for (int i = 0; i < readFile.split(";").length; i++) {
            String fileLine = readFile.split(";")[i];
            if (fileLine.contains("import") && !imported) {
                completeClass += "\n" + importUiActivity;
                imported = true;
            }
            completeClass += fileLine + ";";
            if (i == readFile.split(";").length - 2) {
                completeClass += "\n\n    " + provideUiActivity;
            }
        }
        FileManager.writeFile(f, completeClass.substring(0, completeClass.length() - 1));
    }
}
