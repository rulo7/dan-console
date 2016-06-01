package com.racobos.dangenerator.generators.presentation;

import com.racobos.dangenerator.exceptions.DanKeyNotFoundException;
import com.racobos.dangenerator.generators.Generator;
import com.racobos.dangenerator.overriders.SchemaOverrider;
import com.racobos.dangenerator.overriders.presentation.ManifestOverrider;
import com.racobos.dangenerator.tools.FileManager;
import com.racobos.dangenerator.tools.PathsProvider;
import java.io.File;
import java.io.IOException;

/**
 * @author raulcobos
 */
public class ManifestGenerator extends Generator {

    @Override
    public void generate(String uiName) {
        try {
            File f = FileManager.getFile(getClassPath(), getPostFixClass());
            if (!f.exists()) {
                super.generate(uiName);
            }
            addActivity(uiName, f);
        } catch (IOException | DanKeyNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public SchemaOverrider getOverrider() {
        return new ManifestOverrider();
    }

    @Override
    public String getClassPath() throws IOException, DanKeyNotFoundException {
        return PathsProvider.getManifestPath();
    }

    @Override
    public String getPostFixClass() {
        return "AndroidManifest.xml";
    }

    @Override
    protected File createClassFile(String entityName) throws IOException, DanKeyNotFoundException {
        return FileManager.createFile(getClassPath(), getPostFixClass());
    }

    private void addActivity(String uiName, File f) throws IOException, DanKeyNotFoundException {
        String activity = uiName.substring(0, 1).toUpperCase() + uiName.substring(1) + "Activity";
        String uiPackage = uiName.substring(0, 1).toLowerCase() + uiName.substring(1);
        String manifest = FileManager.readFile(f);
        System.out.println(f.getPath());
        String[] tags = manifest.split("</application>");
        String txt = "<activity android:name=\".ui." + uiPackage + "." + activity + "\"/>";
        System.out.println(tags[0]);        manifest = tags[0] + "\n" + txt + "\n</application>\n" + tags[1];
        FileManager.writeFile(f, manifest);
    }
}
