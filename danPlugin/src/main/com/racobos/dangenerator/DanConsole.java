package com.racobos.dangenerator;

import com.racobos.dangenerator.generators.Generator;
import com.racobos.dangenerator.generators.data.cache.CacheGenerator;
import com.racobos.dangenerator.generators.data.datarepository.DataRepositoryGenerator;
import com.racobos.dangenerator.generators.data.datastore.DataFactoryGenerator;
import com.racobos.dangenerator.generators.data.datastore.DataStoreGenerator;
import com.racobos.dangenerator.generators.data.datastore.imp.CloudDataStoreGenerator;
import com.racobos.dangenerator.generators.data.datastore.imp.DiskDataStoreGenerator;
import com.racobos.dangenerator.generators.data.entity.EntityGenerator;
import com.racobos.dangenerator.generators.data.mapper.MapperGenerator;
import com.racobos.dangenerator.generators.domain.model.ModelGenerator;
import com.racobos.dangenerator.generators.domain.repository.RepositoryGenerator;
import com.racobos.dangenerator.generators.presentation.ApplicationComponentGenerator;
import com.racobos.dangenerator.generators.presentation.ApplicationModuleGenerator;
import com.racobos.dangenerator.tools.FileManager;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author raulcobos
 */
public class DanConsole {

    public void generateEntity() {
        Scanner in = new Scanner(System.in);
        System.out.println("Pls, write the model name: ");
        String entity = in.nextLine();
        Generator[] generators = {
                new EntityGenerator(), new ModelGenerator(), new CacheGenerator(), new ApplicationComponentGenerator(),
                new ApplicationModuleGenerator(), new DataStoreGenerator(), new DataFactoryGenerator(),
                new CloudDataStoreGenerator(), new DiskDataStoreGenerator(), new MapperGenerator(),
                new RepositoryGenerator(), new DataRepositoryGenerator()
        };
        for (Generator generator : generators) {
            generator.generate(entity);
        }
    }

    public void generateProject() {
        String packageName = "com.racobos.app";
        ClassLoader classLoader = getClass().getClassLoader();
        FileManager.unZipIt(classLoader.getResourceAsStream("base_bundle.zip"), "base_bundle.zip");
        //1. rename the package name in packages.dan
        try {
            File packagesDan = new File("./config/packages.dan");
            String content = FileManager.readFile(packagesDan);
            FileManager.writeFile(packagesDan, content.replace("es.raul.app;", packageName));
        } catch (IOException ex) {
            System.err.println("No se pudo sobreescribir el nombre del paquete en packages.dan");
            System.err.println(ex.getMessage());
        }
        //2. rename the paths in paths.dan
        try {
            File packagesDan = new File("./config/paths.dan");
            String content = FileManager.readFile(packagesDan);
            FileManager.writeFile(packagesDan, content.replace("es/raul/app", packageName.replace(".", "/")));
        } catch (IOException ex) {
            System.err.println("No se pudo sobreescribir el las rutas en paths.dan");
            System.err.println(ex.getMessage());
        }
        //3. delete the src folder if this exits
        File app = new File("./app");
        if (app.exists()) {
            removeRecursiveFolder(app);
        } else {
            System.err.println(app.getPath() + " couldn´t be found");
        }
        //4. delete __MACOSX folder
        File __macosx = new File("./__MACOSX");
        if (__macosx.exists()) {
            removeRecursiveFolder(__macosx);
        } else {
            System.err.println(__macosx.getPath() + " couldn´t be found");
        }
        //5. rename the base folders
        String[] currentFolders = "es.raul.app".split("\\.");
        String[] newFolders = packageName.split("\\.");
        for (int i = 0; i < newFolders.length; i++) {
            renameRecursiveFolder(new File("."), currentFolders[i], newFolders[i]);
        }
        //6. replace imports
        replaceImports(new File("."), "es.raul.app", packageName);
    }

    private void removeRecursiveFolder(File file) {
        if (file.isFile() || file.list().length == 0) {
            if (!file.delete()) {
                System.err.println(file.getPath() + " couldn´t be removed");
            }
            return;
        }
        for (String f : file.list()) {
            removeRecursiveFolder(new File(file.getPath(), f));
        }
        if (!file.delete()) {
            System.err.println(file.getPath() + " couldn´t be removed");
        }
    }

    private void renameRecursiveFolder(File root, String src, String newName) {
        if (root.isDirectory()) {
            if (root.listFiles().length > 0) {
                for (File f : root.listFiles()) {
                    renameRecursiveFolder(f, src, newName);
                }
            }
            if (root.getName().equals(src)) {
                if (!root.renameTo(new File(root.getParent(), newName))) {
                    System.err.println(root.getPath() + " couldn´t be renamed");
                }
            }
        }
    }

    private void replaceImports(File root, String original, String packageName) {
        if (root.isFile() && root.getName().contains(".java")) {
            try {
                String content = FileManager.readFile(root);
                FileManager.writeFile(root, content.replace(original, packageName));
            } catch (IOException ex) {
                System.err.println("No se pudo sobreescribir el import en " + root.getPath());
                System.err.println(ex.getMessage());
            }
        }
        if (root.isDirectory() && root.listFiles().length > 0) {
            for (File f : root.listFiles()) {
                replaceImports(f, original, packageName);
            }
        }
    }
}