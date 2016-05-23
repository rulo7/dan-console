package com.rcobos.dangenerator.overriders;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose | Templates
 * and open the template in the editor.
 */

import com.rcobos.dangenerator.exceptions.DanKeyNotFoundException;
import com.rcobos.dangenerator.tools.PackagesProvider;
import java.io.IOException;

/**
 *
 * @author rulo
 */
public abstract class SchemaOverrider {

    private final String ENTITY_CLASSNAME_TAG = "_Entityname_";
    private final String ENTITY_VARNAME_TAG = "_entityname_";
    private final String PACKAGENAME_TAG = "_packagename_";
    //Packages
    private final String APP_PACKAGENAME_TAG = "_app_package_name_";
    private final String ENTITY_PACKAGE_TAG = "_entity_package_";
    private final String MODEL_PACKAGE_TAG = "_model_package_";
    private final String MAPPER_PACKAGE_TAG = "_mapper_package_";
    private final String CACHE_PACKAGE_TAG = "_cache_package_";
    private final String DATAREPOSITORY_PACKAGE_TAG = "_datarepository_package_";
    private final String DATASTORE_PACKAGE_TAG = "_datastore_package_";
    private final String REPOSITORY_PACKAGE_TAG = "_repository_package_";
    private final String USINGCASE_PACKAGE_TAG = "_usingcase_package_";
    private final String APPLICATIONCOMPONENT_PACKAGE_TAG = "_application-component_package_";
    private final String APPLICATIONMODULE_PACKAGE_TAG = "_application-module_package_";

    public String generateSchema(String entity) throws IOException, DanKeyNotFoundException {
        String scheme = getScheme();
        try {
            scheme = scheme.replace(APP_PACKAGENAME_TAG, PackagesProvider.getAppPackage());
            scheme = scheme.replace(ENTITY_CLASSNAME_TAG, entity.substring(0, 1).toUpperCase() + entity.substring(1));
            scheme = scheme.replace(ENTITY_VARNAME_TAG, entity.substring(0, 1).toLowerCase() + entity.substring(1));
            scheme = scheme.replace(PACKAGENAME_TAG, getPackageName());
            scheme = scheme.replace(ENTITY_PACKAGE_TAG, PackagesProvider.getEntityPackage());
            scheme = scheme.replace(MODEL_PACKAGE_TAG, PackagesProvider.getModelPackage());
            scheme = scheme.replace(MAPPER_PACKAGE_TAG, PackagesProvider.getMapperPackage());
            scheme = scheme.replace(CACHE_PACKAGE_TAG, PackagesProvider.getCachePackage());
            scheme = scheme.replace(DATAREPOSITORY_PACKAGE_TAG, PackagesProvider.getDataRepositoryPackage());
            scheme = scheme.replace(DATASTORE_PACKAGE_TAG, PackagesProvider.getDataStorePackage());
            scheme = scheme.replace(REPOSITORY_PACKAGE_TAG, PackagesProvider.getRepositoryPackage());
            scheme = scheme.replace(USINGCASE_PACKAGE_TAG, PackagesProvider.getUsingCasePackage());
            scheme = scheme.replace(APPLICATIONCOMPONENT_PACKAGE_TAG, PackagesProvider.getApplicationComponentPackage());
            scheme = scheme.replace(APPLICATIONMODULE_PACKAGE_TAG, PackagesProvider.getApplicationModulePackage());
        } catch (IOException | DanKeyNotFoundException ex) {
            System.err.println(ex.getMessage());
        }

        return scheme;
    }

    protected abstract String getPackageName() throws IOException, DanKeyNotFoundException;

    protected abstract String getScheme() throws IOException, DanKeyNotFoundException;

}
