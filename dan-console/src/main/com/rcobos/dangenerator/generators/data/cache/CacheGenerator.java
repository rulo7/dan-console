package com.rcobos.dangenerator.generators.data.cache;

import com.rcobos.dangenerator.exceptions.DanKeyNotFoundException;
import com.rcobos.dangenerator.generators.Generator;
import com.rcobos.dangenerator.overriders.SchemaOverrider;
import com.rcobos.dangenerator.overriders.data.cache.CacheSchemaOverrider;
import com.rcobos.dangenerator.tools.PathsProvider;
import java.io.IOException;


/**
 *
 * @author raulcobos
 */
public class CacheGenerator extends Generator {

    @Override
    public SchemaOverrider getOverrider() {
        return new CacheSchemaOverrider();
    }

    @Override
    public String getClassPath() throws IOException, DanKeyNotFoundException {
        return PathsProvider.getCachePath();
    }

    
    @Override
    public String getPostFixClass() {
        return "Cache.java";
    }
    
}