package es.sepla.app.data.local;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by djuarez on 21/3/16.
 */
@Singleton
public class FileManager {

    @Inject
    public FileManager() {
        //Empty for sonar
    }

    public void writeToFile(File file, String fileContent) {
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(fileContent);
            writer.close();
        } catch (IOException e) {
            Log.e(FileManager.class.getSimpleName(), e.getMessage());
        }
    }

    public void writeToFile(File file, InputStream inputStream) {
        try {
            OutputStream outputStream = new FileOutputStream(file);
            byte[] buffer = new byte[8 * 1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            Log.e(FileManager.class.getSimpleName(), e.getMessage());
        }
    }

    public String readFileContent(File file) {
        StringBuilder fileContentBuilder = new StringBuilder();
        if (file.exists()) {
            String stringLine;
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while ((stringLine = bufferedReader.readLine()) != null) {
                    fileContentBuilder.append(stringLine).append('\n');
                }
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                Log.e(FileManager.class.getSimpleName(), e.getMessage());
            }
        }
        return fileContentBuilder.toString();
    }

    public boolean exists(File file) {
        return file.exists();
    }

    public void clearDirectory(File directory) {
        if (directory.exists()) {
            for (File file : directory.listFiles()) {
                file.delete();
            }
        }
    }

    public void writeToPreferences(SharedPreferences sharedPreferences, String key, long value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public long getFromPreferences(SharedPreferences sharedPreferences, String key) {
        return sharedPreferences.getLong(key, 0);
    }

    public String readFileContentFromAssets(Context context, String filename) {
        StringBuilder total = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(filename)));
            total = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                total.append(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            Log.e(FileManager.class.getSimpleName(), e.getMessage());
        }

        return total.toString();
    }
}