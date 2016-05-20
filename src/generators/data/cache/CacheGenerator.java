package generators.data.cache;

import exceptions.DanKeyNotFoundException;
import generators.Generator;
import java.io.IOException;
import overriders.SchemaOverrider;
import overriders.data.cache.CacheSchemaOverrider;
import tools.PathsProvider;

/**
 *
 * @author raulcobos
 */
public class CacheGenerator extends Generator{

    @Override
    public SchemaOverrider getOverrider() {
        return new CacheSchemaOverrider();
    }

    @Override
    public String getClassPath() throws IOException, DanKeyNotFoundException{
        return PathsProvider.getCachePath();
    }

    
    @Override
    public String getPostFixClass() {
        return "Cache.java";
    }
    
}