package com.racobos.dangenerator;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * @author raulcobos
 */
public class DanPlugin implements Plugin<Project> {

    @Override
    public void apply(final Project target) {
        target.getTasks().create("danGenerateProject", DanProjectTask.class, danProjectTask -> {
            danProjectTask.setPackageSyntax((String) target.property("packageSyntax"));
            danProjectTask.setAppName((String) target.property("appName"));
        });
        target.getTasks().create("danGenerateEntity", DanEntityTask.class);
        target.getTasks().create("danGenerateUi", DanUiTask.class);
        target.getTasks().create("danGenerateView", DanViewTask.class);
    }
}