package com.racobos.dangenerator.tools;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

/**
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

    public static void copy(URI srcPath, String destPath) throws IOException {
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

    public static void unZipIt(InputStream inputStream, String outputZip) {
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(new File(outputZip));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int read = 0;
        byte[] bytes = new byte[1024];
        try {
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (outputStream != null) {
                outputStream.close();
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File(outputZip);
        try {
            ZipFile zipFile = new ZipFile(file);
            zipFile.extractAll(new File(".").getPath());
        } catch (ZipException e) {
            e.printStackTrace();
        }
        file.delete();
    }

    public static void changeNameDirectory(String filePath, String newName) {
        File f = new File(filePath);
        f.renameTo(new File(f.getParent(),newName));
    }
}
