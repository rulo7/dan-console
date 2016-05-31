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
        target.getTasks().create("danGenerateEntity", DanEntityTask.class, danEntityTask -> {
            danEntityTask.setEntities(((String) target.property("entityList")).split(","));
        });
        target.getTasks().create("danGenerateUi", DanUiTask.class, danUiTask -> {
            String uiName = (String) target.property("uiName");
            danUiTask.setUiName(uiName);
        });
        target.getTasks().create("danGenerateView", DanViewTask.class, danViewTask -> {
            String uiName = (String) target.property("uiName");
            String viewName = (String) target.property("viewName");
            danViewTask.setUiName(uiName);
            danViewTask.setViewName(viewName);
        });
    }
}