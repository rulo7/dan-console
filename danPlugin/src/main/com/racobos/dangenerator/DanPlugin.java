package com.racobos.dangenerator;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * @author raulcobos
 */
public class DanPlugin implements Plugin<Project> {

    @Override
    public void apply(Project target) {
        target.getTasks().create("danGenerateProject", DanTask.class);
        target.getTasks().create("danGenerateEntity", DanTask.class);
    }
}
