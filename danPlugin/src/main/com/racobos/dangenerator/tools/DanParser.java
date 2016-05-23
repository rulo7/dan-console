package com.racobos.dangenerator.tools;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.racobos.dangenerator.exceptions.DanKeyNotFoundException;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author rulo
 */
public class DanParser {
    private static final String ROW_DELIMITATOR = ";";
    private static final String KEY_VALUE_DELIMITATOR = ":";

    public static String getValueFromDanFile(String filepath, String filename,String key) throws IOException,
            DanKeyNotFoundException {
        File f = FileManager.createFile(filepath, filename);
        String danText = FileManager.readFile(f).replace("\n", "").replace("\r", "");
        for (String danRow : danText.split(ROW_DELIMITATOR)) {
            String keyRow = danRow.split(KEY_VALUE_DELIMITATOR)[0];
            String valueRow = danRow.split(KEY_VALUE_DELIMITATOR)[1];
            if (keyRow.equalsIgnoreCase(key)) {
                return valueRow;
            }
        }

        throw new DanKeyNotFoundException("They key: " + key + " doesn't exists in " + filepath + filename);
    }
}
