/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import tools.FileManager;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author raulcobos
 */
public class DanConsole {

    public void run() {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Pls, write the model name: ");
            String entity = in.nextLine();
            File f = FileManager.createFile("", entity + "Entity.java");
            FileManager.writeFile(f, getEntityClass(entity));
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private String getEntityClass(String entity) {
        return "package es.sepla.app.data.entity;" + System.lineSeparator() + "public class " + entity + "Entity {" + System.lineSeparator() + "}";
    }

}
