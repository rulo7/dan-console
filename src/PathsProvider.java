package tools;

import java.io.IOException;
import exceptions.DanKeyNotFoundException;

/**
 *
 * @author raulcobos
 */
public class PathsProvider extends DanFileProvider {

    private static final String PATHS_FILE = "paths.dan";

    private static final String ENTITY_PACKAGE_PATH = "entity_path";

    public static String getEntityPath() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(ENTITY_PACKAGE_PATH, PATHS_FILE);
    }

    private static final String MAPPER_PACKAGE_PATH = "mapper_path";

    public static String getMapperPath() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(MAPPER_PACKAGE_PATH, PATHS_FILE);
    }

    private static final String CACHE_PACKAGE_PATH = "cache_path";

    public static String getCachePath() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(CACHE_PACKAGE_PATH, PATHS_FILE);
    }

    private static final String DATAREPOSITORY_PACKAGE_PATH = "datarepository_path";

    public static String getDataRepositoryPath() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(DATAREPOSITORY_PACKAGE_PATH, PATHS_FILE);
    }

    private static final String DATASTORE_PACKAGE_PATH = "datastore_path";

    public static String getDataStorePath() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(DATASTORE_PACKAGE_PATH, PATHS_FILE);
    }

    private static final String MODEL_PACKAGE_PATH = "model_path";

    public static String getModelPath() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(MODEL_PACKAGE_PATH, PATHS_FILE);
    }

    private static final String REPOSITORY_PACKAGE_PATH = "repository_path";

    public static String getRepositoryPath() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(REPOSITORY_PACKAGE_PATH, PATHS_FILE);
    }

    private static final String USINGCASE_PACKAGE_PATH = "usingcase_path";

    public static String getUsingCasePath() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(USINGCASE_PACKAGE_PATH, PATHS_FILE);
    }

    private static final String APPLICATIONCOMPONENT_PATH = "application-component_path";

    public static String getApplicationComponentPath() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(APPLICATIONCOMPONENT_PATH, PATHS_FILE);
    }

    private static final String APPLICATIONMODULE_PATH_PATH = "application-module_path";

    public static String getApplicationModulePath() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(APPLICATIONMODULE_PATH_PATH, PATHS_FILE);
    }
}
