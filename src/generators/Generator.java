/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generators;

import exceptions.DanKeyNotFoundException;
import java.io.File;
import java.io.IOException;
import overriders.SchemaOverrider;
import tools.FileManager;

/**
 *
 * @author rulo
 */
public abstract class Generator {

    /**
     * Note: Override this method to add the injections in the necessary clases
     *
     * @param entityName
     */
    public void generate(String entityName) {
        try {
            FileManager.writeFile(createClassFile(entityName), getOverrider().generateSchema(entityName));
        } catch (IOException | DanKeyNotFoundException ex) {
            System.err.println("No se pudo generar la clase");
            System.err.println(ex.getMessage());
        }
    }

    public abstract SchemaOverrider getOverrider();

    public abstract String getClassPath()  throws IOException, DanKeyNotFoundException;

    public abstract String getPostFixClass();

    protected File createClassFile(String entityName) throws IOException, DanKeyNotFoundException {
        return FileManager.createFile(getClassPath(), (entityName.substring(0, 1).toUpperCase() + entityName.substring(1)) + getPostFixClass());
    }
}