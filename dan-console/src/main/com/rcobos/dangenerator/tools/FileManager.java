package com.rcobos.dangenerator.tools;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author raulcobos
 */
public class FileManager {

    public static File createFile(String path, String name) throws IOException {
        // Use relative path for Unix systems
        File f = new File(path + name);
        f.getParentFile().mkdirs();
        f.createNewFile();
        return f;
    }

    public static File getFile(String path, String name) {
        // Use relative path for Unix systems
        File f = new File(path + name);
        return f;
    }

    public static boolean writeFile(File f, String txt) throws FileNotFoundException, IOException {
        if (!f.exists() || !f.canWrite()) {
            return false;
        }

        FileWriter fw = new FileWriter(f.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(txt);
        bw.close();

        return true;
    }

    public static String readFile(File f) throws IOException {
        FileReader reader = null;
        try {
            reader = new FileReader(f);
            char[] chars = new char[(int) f.length()];
            reader.read(chars);
            String content = new String(chars);
            reader.close();
            return content;
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    public static void copy(String srcPath, String destPath) throws IOException {
        File src = new File(srcPath);
        File dest = new File(destPath);
        copy(src, dest);
    }

    private static void copy(File src, File dest) throws IOException {
        if (src.isDirectory()) {
            if (!dest.exists()) {
                dest.mkdir();
            }
            String files[] = src.list();
            for (String fileName : files) {
                copy(new File(src, fileName), new File(dest, fileName));
            }
        } else {
            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
