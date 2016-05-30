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
            //danProjectTask.execute();
        });
        target.getTasks().create("danGenerateEntity", DanEntityTask.class, danEntityTask -> {
            danEntityTask.setEntities(((String) target.property("entityList")).split(","));
            //danEntityTask.execute();
        });
    }
}