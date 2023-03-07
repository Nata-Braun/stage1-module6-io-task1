package com.epam.mjc.io;

import java.io.*;
import java.io.FileInputStream;



import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;


public class FileReader {


    public Profile getDataFromFile(File file) {

        StringBuilder data = new StringBuilder();
        String [] dataSet;
        try (FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath())) {
            int ch;
            while ((ch = fileInputStream.read()) != -1) {
                data.append((char) ch);

            }

        } catch (IOException e) {
            e.printStackTrace();

        }

        dataSet = getArrayFromString(data.toString());
        dataSet = getCorrectValue(dataSet);


        Profile profile = new Profile();
        profile.setName(dataSet[0].trim());
        profile.setAge(parseInt(dataSet[1].trim()));
        profile.setEmail(dataSet[2].trim());
        profile.setPhone(parseLong(dataSet[3].trim()));


        return profile;
    }

    private String[] getArrayFromString(String data) {
        return data.split("\\r?\\n");
    }

    private String[] getCorrectValue(String[] dataSet) {
        String[] setValueForProfile = new String[dataSet.length];
        for (int i = 0; i < dataSet.length; i++) {
            setValueForProfile[i] = dataSet[i].replaceAll("^[^\\s]+", "");

        }
        return setValueForProfile;
    }



}
