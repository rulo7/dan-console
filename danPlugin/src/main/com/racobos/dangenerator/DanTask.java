package com.racobos.dangenerator;

import com.racobos.dangenerator.tools.FileManager;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

/**
 * Created by djuarez on 23/5/16.
 */
public class DanTask extends DefaultTask {

    @TaskAction
    public void danGenerateProject() {
        ClassLoader classLoader = getClass().getClassLoader();
        FileManager.unZipIt(classLoader.getResourceAsStream("base_bundle.zip"), "base_bundle.zip");
    }
}
