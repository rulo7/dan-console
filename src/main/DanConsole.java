package main;

import generators.Generator;
import generators.data.cache.CacheGenerator;
import generators.data.datastore.DataFactoryGenerator;
import generators.data.datastore.DataStoreGenerator;
import generators.data.datastore.imp.CloudDataStoreGenerator;
import generators.data.datastore.imp.DiskDataStoreGenerator;
import generators.data.entity.EntityGenerator;
import generators.domain.model.ModelGenerator;
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

        Generator[] generators = {
            new EntityGenerator(),
            new ModelGenerator(),
            new CacheGenerator(),
            new ApplicationComponentGenerator(),
            new ApplicationModuleGenerator(),
            new DataStoreGenerator(),
            new DataFactoryGenerator(),
            new CloudDataStoreGenerator(),
            new DiskDataStoreGenerator()
        };
        
        for (Generator generator : generators) {
            generator.generate(entity);
        }
    }
}