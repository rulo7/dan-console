package com.racobos.dangenerator;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

/**
 * Created by djuarez on 23/5/16.
 */
public class DanProjectTask extends DefaultTask {

    String originalPackageSyntax = "es.raul.app";
    String packageSyntax = "com.sample.app";
    String appName = "app";
    String originalAppName = "DAN-Example";

    public void setPackageSyntax(String packageSyntax) {
        this.packageSyntax = packageSyntax;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    @TaskAction
    public void danGenerateProject() {
        new DanConsole().generateProject(originalPackageSyntax, packageSyntax, originalAppName, appName);
    }
}
