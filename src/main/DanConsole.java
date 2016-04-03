package main;

import generators.Generator;
import generators.data.cache.CacheGenerator;
import generators.presentation.ApplicationComponentGenerator;
import generators.presentation.ApplicationModuleGenerator;
import java.util.Scanner;

/**
 *
 * @author raulcobos
 */
public class DanConsole {

    public void run() {
        Scanner in = new Scanner(System.in);
        System.out.println("Pls, write the model name: ");
        String entity = in.nextLine();

        Generator[] generators = {new CacheGenerator(), new ApplicationComponentGenerator(), new ApplicationModuleGenerator()};
        for (Generator generator : generators) {
            generator.generate(entity);
        }

        /*
        try {
            System.out.println("Packages");
            System.out.println(PackagesProvider.getEntityPackage());
            System.out.println(PackagesProvider.getModelPackage());
            System.out.println(PackagesProvider.getMapperPackage());
            System.out.println(PackagesProvider.getDataRepositoryPackage());
            System.out.println(PackagesProvider.getDataStorePackage());
            System.out.println(PackagesProvider.getRepositoryPackage());
            System.out.println(PackagesProvider.getUsingCasePackage());

            System.out.println("Paths");
            System.out.println(PathsProvider.getEntityPath());
            System.out.println(PathsProvider.getModelPath());
            System.out.println(PathsProvider.getMapperPath());
            System.out.println(PathsProvider.getDataRepositoryPath());
            System.out.println(PathsProvider.getDataStorePath());
            System.out.println(PathsProvider.getRepositoryPath());
            System.out.println(PathsProvider.getUsingCasePath());
            System.out.println(PathsProvider.getApplicationComponentPath());
            System.out.println(PathsProvider.getApplicationModulePath());

            System.out.println("Schemas");
            System.out.println(SchemasProvider.getEntitySchema());
            System.out.println(SchemasProvider.getModelSchema());
            System.out.println(SchemasProvider.getMapperSchema());
            System.out.println(SchemasProvider.getDataRepositorySchema());
            System.out.println(SchemasProvider.getDataStoreSchema());
            System.out.println(SchemasProvider.getRepositorySchema());
            System.out.println(SchemasProvider.getUsingCaseSchema());

        } catch (IOException | DanKeyNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
         */
    }
}
