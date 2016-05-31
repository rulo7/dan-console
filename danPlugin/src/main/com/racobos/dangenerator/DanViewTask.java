package com.racobos.dangenerator;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

/**
 * Created by djuarez on 24/5/16.
 */
public class DanViewTask extends DefaultTask {

    String uiName = "sample";
    String viewName = "test";

    public void setUiName(String uiName) {
        this.uiName = uiName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    @TaskAction
    public void danGenerateView() {
        new DanConsole().generateView(uiName, viewName);
    }
}
