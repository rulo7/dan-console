package com.racobos.dangenerator.tools;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.racobos.dangenerator.exceptions.DanKeyNotFoundException;
import java.io.IOException;

/**
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

    private static final String APPLICATIONMODULE_PACKAGE_KEY = "application-module_package";

    public static String getApplicationModulePackage() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(APPLICATIONMODULE_PACKAGE_KEY, PACKAGES_FILE);
    }

    private static final String ACTIVITY_PACKAGE_KEY = "activity_package";

    public static String getActivityPackage() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(ACTIVITY_PACKAGE_KEY, PACKAGES_FILE);
    }

    private static final String ACTIVITYCOMPONENT_PACKAGE_KEY = "activity-component_package";

    public static String getActivityComponentPackage() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(ACTIVITYCOMPONENT_PACKAGE_KEY, PACKAGES_FILE);
    }

    private static final String FRAGMENTCOMPONENT_PACKAGE_KEY = "fragment-component_package";

    public static String getFragmentComponentPackage() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(FRAGMENTCOMPONENT_PACKAGE_KEY, PACKAGES_FILE);
    }

    private static final String MANIFEST_PACKAGE_KEY = "manifest_package";

    public static String getManifestPackage() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(MANIFEST_PACKAGE_KEY, PACKAGES_FILE);
    }

    private static final String FRAGMENT_PACKAGE_KEY = "fragment_package";

    public static String getFragmentPackage() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(FRAGMENT_PACKAGE_KEY, PACKAGES_FILE);
    }

    private static final String VIEW_PACKAGE_KEY = "view_package";

    public static String getViewPackage() throws IOException, DanKeyNotFoundException {
        return getValueFromDanFile(VIEW_PACKAGE_KEY, PACKAGES_FILE);
    }
}
