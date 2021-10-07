package jvm.pablohdz.emailbasicauthenticationservice.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jvm.pablohdz.emailbasicauthenticationservice.persistence.EnvDatabase;

public class DatabaseData implements EnvDatabase {

    @Override
    public String getUrlDatabase() {
        return data().get(0);
    }

    @Override
    public String getUserDatabase() {
        return null;
    }

    @Override
    public String getPasswordDatabase() {
        return null;
    }

    private List<String> data() {
        List<String> list = new ArrayList<>();

        try {
            BufferedReader fileReader = new BufferedReader(
                    new FileReader("src/main/resources/database.connection"));

            String st;

            while ((st = fileReader.readLine()) != null) {
                list.add(st);
            }

            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;

    }
}
