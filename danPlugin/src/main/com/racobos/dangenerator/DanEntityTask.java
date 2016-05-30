package com.racobos.dangenerator;

import java.util.Arrays;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

/**
 * Created by djuarez on 24/5/16.
 */
public class DanEntityTask extends DefaultTask {

    String[] entities;

    public void setEntities(String[] entities) {
        this.entities = entities;
    }

    @TaskAction
    public void danGenerateEntity() {
        for(String entity: Arrays.asList(entities)) {
            new DanConsole().generateEntity(entity);
        }
    }
}
