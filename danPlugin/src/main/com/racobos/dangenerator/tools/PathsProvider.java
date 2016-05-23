package com.racobos.dangenerator.tools;

import com.racobos.dangenerator.exceptions.DanKeyNotFoundException;
import java.io.IOException;

/**
 *
 * @author raulcobos
 */
public class PathsProvider extends DanFileProvider {

    private static final String PATHS_FILE = "paths.dan";

    private static final String ENTITY_PACKAGE_PATH_KEY = "entity_path";

    public static String getEntityPath() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(ENTITY_PACKAGE_PATH_KEY, PATHS_FILE);
    }

    private static final String MAPPER_PACKAGE_PATH_KEY = "mapper_path";

    public static String getMapperPath() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(MAPPER_PACKAGE_PATH_KEY, PATHS_FILE);
    }

    private static final String CACHE_PACKAGE_PATH_KEY = "cache_path";

    public static String getCachePath() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(CACHE_PACKAGE_PATH_KEY, PATHS_FILE);
    }

    private static final String DATAREPOSITORY_PACKAGE_PATH_KEY = "datarepository_path";

    public static String getDataRepositoryPath() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(DATAREPOSITORY_PACKAGE_PATH_KEY, PATHS_FILE);
    }

    private static final String DATASTORE_PACKAGE_PATH_KEY = "datastore_path";

    public static String getDataStorePath() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(DATASTORE_PACKAGE_PATH_KEY, PATHS_FILE);
    }

    private static final String MODEL_PACKAGE_PATH_KEY = "model_path";

    public static String getModelPath() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(MODEL_PACKAGE_PATH_KEY, PATHS_FILE);
    }

    private static final String REPOSITORY_PACKAGE_PATH_KEY = "repository_path";

    public static String getRepositoryPath() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(REPOSITORY_PACKAGE_PATH_KEY, PATHS_FILE);
    }

    private static final String USINGCASE_PACKAGE_PATH_KEY = "usingcase_path";

    public static String getUsingCasePath() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(USINGCASE_PACKAGE_PATH_KEY, PATHS_FILE);
    }

    private static final String APPLICATIONCOMPONENT_PATH_KEY = "application-component_path";

    public static String getApplicationComponentPath() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(APPLICATIONCOMPONENT_PATH_KEY, PATHS_FILE);
    }

    private static final String APPLICATIONMODULE_PATH_KEY = "application-module_path";

    public static String getApplicationModulePath() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(APPLICATIONMODULE_PATH_KEY, PATHS_FILE);
    }
}
