package com.racobos.dangenerator;

import com.racobos.dangenerator.tools.FileManager;
import java.io.IOException;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

/**
 * Created by djuarez on 23/5/16.
 */
public class DanTask extends DefaultTask {

    @TaskAction
    public void danGenerateProject() {
        try {
            FileManager.copy("resources",getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @TaskAction
    public void danGenerateEntity() {
        new DanConsole().run();

    }

}
