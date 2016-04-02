/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package overriders;

import exceptions.DanKeyNotFoundException;
import java.io.IOException;
import tools.PackagesProvider;

/**
 *
 * @author rulo
 */
public abstract class SchemaOverrider {

    private final String APPPACKAGENAME_TAG = "_app_package_name_";
    private final String ENTITY_CLASSNAME_TAG = "_Entityname_";
    private final String ENTITY_VARNAME_TAG = "_entityname_";
    private final String PACKAGENAME_TAG = "_packagename_";
    private final String ENTITY_PACKAGE_TAG = "_entity_package_";

    public String generateSchema(String entity) throws IOException, DanKeyNotFoundException{
        String scheme = getScheme();
        try {
            scheme = scheme.replace(APPPACKAGENAME_TAG, PackagesProvider.getAppPackage());
            scheme = scheme.replace(ENTITY_CLASSNAME_TAG, entity.substring(0, 1).toUpperCase() + entity.substring(1));
            scheme = scheme.replace(ENTITY_VARNAME_TAG, entity.substring(0, 1).toLowerCase() + entity.substring(1));
            scheme = scheme.replace(PACKAGENAME_TAG, getPackageName());
            scheme = scheme.replace(ENTITY_PACKAGE_TAG, PackagesProvider.getEntityPackage());
        } catch (IOException | DanKeyNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        
        return scheme;
    }

    protected abstract String getPackageName() throws IOException, DanKeyNotFoundException;

    protected abstract String getScheme() throws IOException, DanKeyNotFoundException;

}