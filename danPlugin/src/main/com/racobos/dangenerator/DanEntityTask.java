package com.racobos.dangenerator;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

/**
 * Created by djuarez on 24/5/16.
 */
public class DanEntityTask extends DefaultTask {

    @TaskAction
    public void danGenerateEntity() {
        new DanConsole().generateEntity();
    }
}
