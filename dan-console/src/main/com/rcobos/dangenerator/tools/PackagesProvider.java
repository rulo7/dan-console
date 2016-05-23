package com.rcobos.dangenerator.tools;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.rcobos.dangenerator.exceptions.DanKeyNotFoundException;
import java.io.IOException;

/**
 *
 * @author raulcobos
 */
public class PackagesProvider extends DanFileProvider {

    private static final String PACKAGES_FILE = "packages.dan";

    private static final String APP_PACKAGE_KEY = "app_package_name";

    public static String getAppPackage() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(APP_PACKAGE_KEY, PACKAGES_FILE);
    }

    private static final String ENTITY_PACKAGE_KEY = "entity_package";

    public static String getEntityPackage() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(ENTITY_PACKAGE_KEY, PACKAGES_FILE);
    }

    private static final String MAPPER_PACKAGE_KEY = "mapper_package";

    public static String getMapperPackage() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(MAPPER_PACKAGE_KEY, PACKAGES_FILE);
    }

    private static final String CACHE_PACKAGE_KEY = "cache_package";

    public static String getCachePackage() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(CACHE_PACKAGE_KEY, PACKAGES_FILE);
    }

    private static final String DATAREPOSITORY_PACKAGE_KEY = "datarepository_package";

    public static String getDataRepositoryPackage() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(DATAREPOSITORY_PACKAGE_KEY, PACKAGES_FILE);
    }

    private static final String DATASTORE_PACKAGE_KEY = "datastore_package";

    public static String getDataStorePackage() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(DATASTORE_PACKAGE_KEY, PACKAGES_FILE);
    }

    private static final String MODEL_PACKAGE_KEY = "model_package";

    public static String getModelPackage() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(MODEL_PACKAGE_KEY, PACKAGES_FILE);
    }

    private static final String REPOSITORY_PACKAGE_KEY = "repository_package";

    public static String getRepositoryPackage() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(REPOSITORY_PACKAGE_KEY, PACKAGES_FILE);
    }

    private static final String USINGCASE_PACKAGE_KEY = "usingcase_package";

    public static String getUsingCasePackage() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(USINGCASE_PACKAGE_KEY, PACKAGES_FILE);
    }

    private static final String APPLICATIONCOMPONENT_PACKAGE_KEY = "application-component_package";

    public static String getApplicationComponentPackage() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(APPLICATIONCOMPONENT_PACKAGE_KEY, PACKAGES_FILE);
    }

    private static final String APPLICATIONMODULE_PATH_KEY = "application-module_package";

    public static String getApplicationModulePackage() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(APPLICATIONMODULE_PATH_KEY, PACKAGES_FILE);
    }
}
