package com.racobos.dangenerator;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

/**
 * Created by djuarez on 24/5/16.
 */
public class DanUiTask extends DefaultTask {

    String uiName = "sample";

    public void setUiName(String uiName) {
        this.uiName = uiName;
    }

    @TaskAction
    public void danGenerateUi() {
        new DanConsole().generateUi(uiName);
    }
}
