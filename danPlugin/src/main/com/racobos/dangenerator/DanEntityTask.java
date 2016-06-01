package com.racobos.dangenerator;

import groovy.lang.MissingPropertyException;
import java.util.Arrays;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

/**
 * Created by djuarez on 24/5/16.
 */
public class DanEntityTask extends DefaultTask {

    private static final String USAGE = "Usage: ./gradlew danGenerateEntity -Pentities=<entity1>,<entity2>";

    @TaskAction
    public void danGenerateEntity() {
        try {
            String entities = (String) this.getProject().property("entities");
            if (entities != null) {
                for(String entity: Arrays.asList(entities.split(","))) {
                    new DanConsole().generateEntity(entity);
                }
            } else {
                throw new MissingPropertyException("");
            }
        } catch (MissingPropertyException e) {
            System.err.println(USAGE);
            throw e;
        }

    }
}
