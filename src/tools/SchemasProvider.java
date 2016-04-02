/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import exceptions.DanKeyNotFoundException;
import java.io.IOException;

/**
 *
 * @author raulcobos
 */
public class SchemasProvider {

    public static final String SCHEMAS_PATH = DanFileProvider.CONFIG_PATH + "schemas/";

    private static final String ENTITY_SCH = "Entity.sch";

    public static String getEntitySchema() throws IOException, DanKeyNotFoundException {
        return FileManager.readFile(FileManager.getFile(SCHEMAS_PATH, ENTITY_SCH));
    }

    private static final String MAPPER_SCH = "Mapper.sch";

    public static String getMapperSchema() throws IOException, DanKeyNotFoundException {
        return FileManager.readFile(FileManager.getFile(SCHEMAS_PATH, MAPPER_SCH));
    }

    private static final String CACHE_SCH = "Cache.sch";

    public static String getCacheSchema() throws IOException, DanKeyNotFoundException {
        return FileManager.readFile(FileManager.getFile(SCHEMAS_PATH, CACHE_SCH));
    }

    private static final String DATAREPOSITORY_SCH = "DataRepository.sch";

    public static String getDataRepositorySchema() throws IOException, DanKeyNotFoundException {
        return FileManager.readFile(FileManager.getFile(SCHEMAS_PATH, DATAREPOSITORY_SCH));
    }

    private static final String DATASTORE_SCH = "DataStore.sch";

    public static String getDataStoreSchema() throws IOException, DanKeyNotFoundException {
        return FileManager.readFile(FileManager.getFile(SCHEMAS_PATH, DATASTORE_SCH));
    }

    private static final String MODEL_SCH = "Model.sch";

    public static String getModelSchema() throws IOException, DanKeyNotFoundException {
        return FileManager.readFile(FileManager.getFile(SCHEMAS_PATH, MODEL_SCH));
    }

    private static final String REPOSITORY_SCH = "Repository.sch";

    public static String getRepositorySchema() throws IOException, DanKeyNotFoundException {
        return FileManager.readFile(FileManager.getFile(SCHEMAS_PATH, REPOSITORY_SCH));
    }

    private static final String USINGCASE_SCH = "UsingCase.sch";

    public static String getUsingCaseSchema() throws IOException, DanKeyNotFoundException {
        return FileManager.readFile(FileManager.getFile(SCHEMAS_PATH, USINGCASE_SCH));
    }
}
