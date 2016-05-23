package com.racobos.dangenerator.generators.presentation;

import com.racobos.dangenerator.tools.PackagesProvider;
import com.racobos.dangenerator.exceptions.DanKeyNotFoundException;
import com.racobos.dangenerator.generators.Generator;
import com.racobos.dangenerator.overriders.SchemaOverrider;
import com.racobos.dangenerator.overriders.presentation.ApplicationComponentOverrider;
import com.racobos.dangenerator.tools.FileManager;
import com.racobos.dangenerator.tools.PathsProvider;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author raulcobos
 */
public class ApplicationComponentGenerator extends Generator {

    @Override
    public void generate(String entityName) {
        try {
            File f = FileManager.getFile(getClassPath(), getPostFixClass());
            if (!f.exists()) {
                super.generate(entityName);
            }

            addImportsAndInjections(entityName, f);

        } catch (IOException | DanKeyNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public SchemaOverrider getOverrider() {
        return new ApplicationComponentOverrider();
    }

    @Override
    public String getClassPath() throws IOException, DanKeyNotFoundException {
        return PathsProvider.getApplicationComponentPath();
    }

    @Override
    public String getPostFixClass() {
        return "ApplicationComponent.java";
    }

    @Override
    protected File createClassFile(String entityName) throws IOException, DanKeyNotFoundException {
        return FileManager.createFile(getClassPath(), getPostFixClass());
    }

    private void addImportsAndInjections(String entityName, File f) throws IOException, DanKeyNotFoundException {
        String readFile = FileManager.readFile(f);
        String modelClassName = entityName.substring(0, 1).toUpperCase() + entityName.substring(1);
        String importEntityRepository = "import " + PackagesProvider.getAppPackage() + "." + PackagesProvider
                .getRepositoryPackage() + "." + modelClassName + "Repository;";
        String provideEntityRepository = modelClassName + "Repository " + entityName.substring(0, 1).toLowerCase() + entityName.substring(1) + "Repository();";

        String completeClass = "";
        boolean imported = false;
        for (int i = 0; i < readFile.split(";").length; i++) {
            String fileLine = readFile.split(";")[i];

            if (fileLine.contains("import") && !imported) {
                completeClass += "\n" + importEntityRepository;
                imported = true;
            }

            completeClass += fileLine + ";";

            if (i == readFile.split(";").length - 2) {
                completeClass += "\n\n    " + provideEntityRepository;
            }
        }

        FileManager.writeFile(f, completeClass.substring(0, completeClass.length() - 1));
    }

}
