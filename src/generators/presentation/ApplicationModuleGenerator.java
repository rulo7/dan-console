package generators.presentation;

import exceptions.DanKeyNotFoundException;
import generators.Generator;
import java.io.File;
import java.io.IOException;
import overriders.SchemaOverrider;
import overriders.presentation.ApplicationModuleOverrider;
import tools.FileManager;
import tools.PackagesProvider;
import tools.PathsProvider;

/**
 *
 * @author raulcobos
 */
public class ApplicationModuleGenerator extends Generator {

    @Override
    public SchemaOverrider getOverrider() {
        return new ApplicationModuleOverrider();
    }

    @Override
    public String getClassPath() throws IOException, DanKeyNotFoundException {
        return PathsProvider.getApplicationModulePath();
    }

    @Override
    public String getPostFixClass() {
        return "ApplicationModule.java";
    }

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
    protected File createClassFile(String entityName) throws IOException, DanKeyNotFoundException {
        return FileManager.createFile(getClassPath(), getPostFixClass());
    }

    private void addImportsAndInjections(String entityName, File f) throws IOException, DanKeyNotFoundException {
        String readFile = FileManager.readFile(f);
        String modelClassName = entityName.substring(0, 1).toUpperCase() + entityName.substring(1);
        String modelName = entityName.substring(0, 1).toLowerCase() + entityName.substring(1);
        String importEntityRepository = "import " + PackagesProvider.getAppPackage() + "." + PackagesProvider.getRepositoryPackage() + "." + modelClassName + "Repository;";
        String importEntityDataRepository = "import " + PackagesProvider.getAppPackage() + "." + PackagesProvider.getDataRepositoryPackage() + "." + modelClassName + "DataRepository;";

        String provideEntityDataRepository
                = "\n@Provides\n"
                + "@Singleton\n"
                + modelClassName + "Repository "
                + "provide" + modelClassName + "Repository(" + modelClassName + "DataRepository dataRepository) {\n"
                + "return dataRepository;\n"
                + "";

        String completeClass = "";
        boolean imported = false;
        for (int i = 0; i < readFile.split(";").length; i++) {
            String fileLine = readFile.split(";")[i];

            if (fileLine.contains("import") && !imported) {
                completeClass += "\n" + importEntityRepository;
                completeClass += "\n" + importEntityDataRepository;
                imported = true;
            }

            completeClass += fileLine + ";";

            if (i == readFile.split(";").length - 2) {
                completeClass += "\n}" + provideEntityDataRepository;
            }
        }

        FileManager.writeFile(f, completeClass.substring(0, completeClass.length() - 1));
    }

}
