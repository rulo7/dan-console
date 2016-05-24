package com.racobos.dangenerator;

import com.racobos.dangenerator.generators.data.datastore.DataFactoryGenerator;
import com.racobos.dangenerator.generators.data.datastore.DataStoreGenerator;
import com.racobos.dangenerator.generators.data.datastore.imp.CloudDataStoreGenerator;
import com.racobos.dangenerator.generators.data.datastore.imp.DiskDataStoreGenerator;
import com.racobos.dangenerator.generators.presentation.ApplicationComponentGenerator;
import com.racobos.dangenerator.generators.presentation.ApplicationModuleGenerator;
import com.racobos.dangenerator.generators.Generator;
import com.racobos.dangenerator.generators.data.cache.CacheGenerator;
import com.racobos.dangenerator.generators.data.datarepository.DataRepositoryGenerator;
import com.racobos.dangenerator.generators.data.entity.EntityGenerator;
import com.racobos.dangenerator.generators.data.mapper.MapperGenerator;
import com.racobos.dangenerator.generators.domain.model.ModelGenerator;
import com.racobos.dangenerator.generators.domain.repository.RepositoryGenerator;
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
            new DiskDataStoreGenerator(),
            new MapperGenerator(),
            new RepositoryGenerator(),
            new DataRepositoryGenerator()
        };

        for (Generator generator : generators) {
            generator.generate(entity);
        }
    }
}