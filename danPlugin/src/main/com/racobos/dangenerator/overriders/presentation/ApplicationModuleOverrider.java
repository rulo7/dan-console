package com.racobos.dangenerator.overriders.presentation;

import com.racobos.dangenerator.exceptions.DanKeyNotFoundException;
import com.racobos.dangenerator.overriders.SchemaOverrider;
import com.racobos.dangenerator.tools.PackagesProvider;
import com.racobos.dangenerator.tools.SchemasProvider;
import java.io.IOException;


/**
 *
 * @author rulo
 */
public class ApplicationModuleOverrider extends SchemaOverrider {

    @Override
    protected String getPackageName() throws IOException, DanKeyNotFoundException {
        return PackagesProvider.getApplicationModulePackage();
    }

    @Override
    protected String getScheme() throws IOException, DanKeyNotFoundException {
        return SchemasProvider.getApplicationModuleSchema();
    }
}
