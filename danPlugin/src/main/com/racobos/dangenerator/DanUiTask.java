package com.racobos.dangenerator;

import groovy.lang.MissingPropertyException;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

/**
 * Created by djuarez on 24/5/16.
 */
public class DanUiTask extends DefaultTask {

    private static final String USAGE = "Usage: ./gradlew danGenerateUi -PuiName=<uiName>";

    @TaskAction
    public void danGenerateUi() {
        try {
            String argUiName = (String) this.getProject().property("uiName");
            if (argUiName != null) {
                new DanConsole().generateUi(argUiName);
            } else {
                throw new MissingPropertyException("");
            }
        } catch (MissingPropertyException e) {
            System.err.println(USAGE);
            throw e;
        }
    }
}
