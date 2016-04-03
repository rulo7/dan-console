package overriders.presentation;

import exceptions.DanKeyNotFoundException;
import java.io.IOException;
import overriders.SchemaOverrider;
import tools.PackagesProvider;
import tools.SchemasProvider;

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
