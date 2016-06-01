package com.racobos.dangenerator;

import groovy.lang.MissingPropertyException;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

/**
 * Created by djuarez on 24/5/16.
 */
public class DanViewTask extends DefaultTask {

    private static final String USAGE = "Usage: ./gradlew danGenerateView -PuiName=<uiName> -PviewName=<viewName>";

    @TaskAction
    public void danGenerateView() {
        try {
            String argUiName = (String) this.getProject().property("uiName");
            String argViewName = (String) this.getProject().property("viewName");
            if (argUiName != null && argViewName != null) {
                new DanConsole().generateView(argUiName, argViewName);
            } else {
                throw new MissingPropertyException("");
            }
        } catch (MissingPropertyException e) {
            System.err.println(USAGE);
            throw e;
        }
    }
}
