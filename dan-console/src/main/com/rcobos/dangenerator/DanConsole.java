package com.rcobos.dangenerator;

import com.rcobos.dangenerator.generators.Generator;
import com.rcobos.dangenerator.generators.data.cache.CacheGenerator;
import com.rcobos.dangenerator.generators.data.datarepository.DataRepositoryGenerator;
import com.rcobos.dangenerator.generators.data.datastore.DataFactoryGenerator;
import com.rcobos.dangenerator.generators.data.datastore.DataStoreGenerator;
import com.rcobos.dangenerator.generators.data.datastore.imp.CloudDataStoreGenerator;
import com.rcobos.dangenerator.generators.data.datastore.imp.DiskDataStoreGenerator;
import com.rcobos.dangenerator.generators.data.entity.EntityGenerator;
import com.rcobos.dangenerator.generators.data.mapper.MapperGenerator;
import com.rcobos.dangenerator.generators.domain.model.ModelGenerator;
import com.rcobos.dangenerator.generators.domain.repository.RepositoryGenerator;
import com.rcobos.dangenerator.generators.presentation.ApplicationComponentGenerator;
import com.rcobos.dangenerator.generators.presentation.ApplicationModuleGenerator;
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