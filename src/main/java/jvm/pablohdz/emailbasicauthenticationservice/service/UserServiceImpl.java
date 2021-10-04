package jvm.pablohdz.emailbasicauthenticationservice.service;

import jvm.pablohdz.emailbasicauthenticationservice.controller.UserRequest;

public class UserServiceImpl
        implements UserService {
    private final Database database;

    public UserServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public void saveUser(UserRequest userRequest) {
        database.create(userRequest);
    }
}
