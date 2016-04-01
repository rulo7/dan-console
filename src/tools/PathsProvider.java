/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.io.File;
import java.io.IOException;
import exceptions.DanKeyNotFoundException;

/**
 *
 * @author raulcobos
 */
public class PathsProvider {

    private static final String ENTITY_PACKAGE_KEY = "entity_package";

    public static String getEntityPackage() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(ENTITY_PACKAGE_KEY);
    }

    private static final String MAPPER_PACKAGE_KEY = "mapper_package";

    public static String getMapperPackage() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(MAPPER_PACKAGE_KEY);
    }

    private static final String CACHE_PACKAGE_KEY = "cache_package";

    public static String getCachePackage() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(CACHE_PACKAGE_KEY);
    }

    private static final String DATAREPOSITORY_PACKAGE_KEY = "datarepository_package";

    public static String getDataRepositoryPackage() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(DATAREPOSITORY_PACKAGE_KEY);
    }

    private static final String DATASTORE_PACKAGE_KEY = "datastore_package";

    public static String getDataStorePackage() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(DATASTORE_PACKAGE_KEY);
    }

    private static final String MODEL_PACKAGE_KEY = "model_package";

    public static String getModelPackage() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(MODEL_PACKAGE_KEY);
    }

    private static final String REPOSITORY_PACKAGE_KEY = "repository_package";

    public static String getRepositoryPackage() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(REPOSITORY_PACKAGE_KEY);
    }

    private static final String USINGCASE_PACKAGE_KEY = "usingcase_package";

    public static String getUsingCasePackage() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(USINGCASE_PACKAGE_KEY);
    }

    private static final String APPLICATIONCOMPONENT_PATH_KEY = "application-component_path";

    public static String getApplicationComponentPath() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(APPLICATIONCOMPONENT_PATH_KEY);
    }

    private static final String APPLICATIONMODULE_PATH_KEY = "application-module_path";

    public static String getApplicationModulePath() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(APPLICATIONMODULE_PATH_KEY);
    }

    private static final String CONFIG_PATH = "config/";
    private static final String CONFIG_NAME = "config.dan";
    private static final String ROW_DELIMITATOR = ";";
    private static final String KEY_VALUE_DELIMITATOR = ":";

    public static String getValueFromDanFile(String key) throws IOException, DanKeyNotFoundException {
        File f = FileManager.createFile(CONFIG_PATH, CONFIG_NAME);
        String danText = FileManager.readFile(f);
        for (String danRow : danText.split(ROW_DELIMITATOR)) {
            String keyRow = danRow.split(KEY_VALUE_DELIMITATOR)[0];
            String valueRow = danRow.split(KEY_VALUE_DELIMITATOR)[1];
            if (keyRow.equalsIgnoreCase(key)) {
                return valueRow;
            }
        }

        throw new DanKeyNotFoundException("They key: " + key + "doesn't exists in " + CONFIG_PATH + CONFIG_NAME);
    }
}
