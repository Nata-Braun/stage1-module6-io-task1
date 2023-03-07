package com.epam.mjc.io;

import java.io.*;
import java.io.FileInputStream;
import java.util.Arrays;


import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;


public class FileReader {
    static String directory = "C:\\Users\\Nata Braun\\IdeaProjects\\stage1-module6-io-task1\\src\\main\\resources";
    static String fileName = "Profile.txt";
    static String absolutPath = directory + File.separator + fileName;


    public Profile getDataFromFile(File file) {

        StringBuilder data = new StringBuilder();
        String [] dataSet;
        try (FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath())) {
            int ch;
            while ((ch = fileInputStream.read()) != -1) {
                //System.out.println((char)ch);
                data.append((char) ch);

            }
            fileInputStream.close();

            System.out.println(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }

        //System.out.println(Arrays.toString(getArrayFromString(data)));
        dataSet = getArrayFromString(data.toString());
        dataSet = getCorrectValue(dataSet);
        System.out.println (Arrays.toString (getCorrectValue(dataSet)));

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


    public static void main (String [] arqs) {
        FileReader fileReader = new FileReader();
        System.out.println(fileReader.getDataFromFile(new File(absolutPath)));

    }

}
