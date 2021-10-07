package jvm.pablohdz.emailbasicauthenticationservice.dao;

import jvm.pablohdz.emailbasicauthenticationservice.controller.UserRequest;
import jvm.pablohdz.emailbasicauthenticationservice.persistence.SqlDatabase;
import jvm.pablohdz.emailbasicauthenticationservice.service.Database;

public class UserDao {
    private final Database database;

    public UserDao(Database database) {
        this.database = database;
    }


    public long create(UserRequest request) {
        return database.create(request);
    }
}
