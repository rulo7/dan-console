package com.rcobos.dangenerator.overriders.presentation;

import com.rcobos.dangenerator.exceptions.DanKeyNotFoundException;
import com.rcobos.dangenerator.overriders.SchemaOverrider;
import com.rcobos.dangenerator.tools.PackagesProvider;
import com.rcobos.dangenerator.tools.SchemasProvider;
import java.io.IOException;

/**
 *
 * @author rulo
 */
public class ApplicationComponentOverrider extends SchemaOverrider {

    @Override
    protected String getPackageName() throws IOException, DanKeyNotFoundException {
        return PackagesProvider.getApplicationComponentPackage();
    }

    @Override
    protected String getScheme() throws IOException, DanKeyNotFoundException {
        return SchemasProvider.getApplicationComponentSchema();
    }
}
