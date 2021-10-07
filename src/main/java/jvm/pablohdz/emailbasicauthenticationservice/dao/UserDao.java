package jvm.pablohdz.emailbasicauthenticationservice.dao;

import jvm.pablohdz.emailbasicauthenticationservice.controller.UserRequest;
import jvm.pablohdz.emailbasicauthenticationservice.persistence.SqlDatabase;

public class UserDao {
    private final SqlDatabase database;

    public UserDao(SqlDatabase database) {
        this.database = database;
    }


    public long create(UserRequest request) {
        return database.create(request);
    }
}
