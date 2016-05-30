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
import java.io.InputStream;

/**
 * @author raulcobos
 */
public class DanConsole {

    public void generateEntity(String entity) {
        System.out.println("Generating entity: " + entity);
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

    public void generateProject(String packageName) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("base_bundle.zip");
        if(inputStream != null) {
            FileManager.unZipIt(inputStream, "base_bundle.zip");
        } else {
            System.err.println("No se pudo abrir el base_bundle.zip");
            return;
        }

        //1. rename the package name in packages.dan
        try {
            File packagesDan = new File("config/packages.dan");
            String content = FileManager.readFile(packagesDan);
            FileManager.writeFile(packagesDan, content.replace("es.raul.app;", packageName));
        } catch (IOException ex) {
            System.err.println("No se pudo sobreescribir el nombre del paquete en packages.dan");
            System.err.println(ex.getMessage());
        }
        //
        ////2. rename the paths in paths.dan
        try {
            File packagesDan = new File("config/paths.dan");
            String content = FileManager.readFile(packagesDan);
            FileManager.writeFile(packagesDan, content.replace("es/raul/app", packageName.replace(".", "/")));
        } catch (IOException ex) {
            System.err.println("No se pudo sobreescribir el las rutas en paths.dan");
            System.err.println(ex.getMessage());
        }

        //3. rename all folders
        File root = new File(".");
        System.out.println("path " + root.getAbsolutePath());
        String[] original = "es.raul.app".split(".");
        String[] replace = packageName.split(".");
        for(int i = 0; i < original.length ; i++) {
            renameRecursiveFolder(root, original[i], replace[i]);
        }

        //4. delete the src folder if this exits
        File app = new File("./app");
        if (app.exists()) {
            removeRecursiveFolder(app);
        }else{
            System.err.println(app.getPath() + app.getName() + " couldn´t be found");
        }


        //5. delete __MACOSX folder
        File __macosx = new File("./__MACOSX");
        if (__macosx.exists()) {
            removeRecursiveFolder(__macosx);
        }else{
            System.err.println(__macosx.getPath() + __macosx.getName() + " couldn´t be found");
        }
    }

    private void removeRecursiveFolder(File file) {
        if (file.isFile() || file.list().length == 0) {
            if (file.delete()) {
                //System.out.println(file.getPath() + file.getName() + " removed");
            } else {
                System.err.println(file.getPath() + file.getName() + " couldn´t be removed");
            }
            return;
        }
        for (String f : file.list()) {
            removeRecursiveFolder(new File(file.getPath(), f));
        }
        if (file.delete()) {
            //System.out.println(file.getPath() + file.getName() + " removed");
        } else {
            System.err.println(file.getPath() + file.getName() + " couldn´t be removed");
        }
    }


    private void renameRecursiveFolder(File file, String pattern, String replace) {
        if (file.isDirectory()) {
            if(file.list().length > 0) {
                for (String f : file.list()) {
                    renameRecursiveFolder(new File(file.getPath(), f), pattern, replace);
                }
            }

            if (file.getName().contains(pattern)) {
                System.out.println(file.getPath() + file.getName());
                boolean result = file.renameTo(new File(replace));
                System.out.println(file.getPath() + file.getName() + " renamed " + result + " to " + replace);
            }
        }
    }

}