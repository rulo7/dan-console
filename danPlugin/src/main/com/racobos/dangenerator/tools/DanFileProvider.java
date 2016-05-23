package com.racobos.dangenerator.tools;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.racobos.dangenerator.exceptions.DanKeyNotFoundException;
import java.io.IOException;

/**
 *
 * @author rulo
 */
public class DanFileProvider {
    public static final String CONFIG_PATH = "config/";
    
    protected static String getValueFromDanFile(String key, String fileconfig) throws IOException,
            DanKeyNotFoundException {
        return DanParser.getValueFromDanFile(CONFIG_PATH, fileconfig, key);
    }
}
