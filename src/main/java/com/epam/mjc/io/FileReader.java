package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file) {
        String name = "", email = "";
        int age = 0;
        long phone = 0;

        try (BufferedReader in = new BufferedReader(new java.io.FileReader(file))) {
            String str;

            while ((str = in.readLine()) != null) {
                String[] values = str.split(": ");

                switch (values[0]) {
                    case "Name":
                        name = values[1];
                        break;
                    case "Age":
                        age = Integer.parseInt(values[1]);
                        break;
                    case "Email":
                        email = values[1];
                        break;
                    case "Phone":
                        phone = Long.parseLong(values[1]);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Profile(name, age, email, phone);
    }
}
