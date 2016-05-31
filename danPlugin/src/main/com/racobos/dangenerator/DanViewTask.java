package com.racobos.dangenerator;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

/**
 * Created by djuarez on 24/5/16.
 */
public class DanViewTask extends DefaultTask {

    String uiName;
    String viewName;

    @TaskAction
    public void danGenerateEntity() {
        new DanConsole().generateView(uiName, viewName);
    }
}
