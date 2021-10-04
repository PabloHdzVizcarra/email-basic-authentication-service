package jvm.pablohdz.emailbasicauthenticationservice.service;

import jvm.pablohdz.emailbasicauthenticationservice.controller.UserRequest;

public interface Database {
    void create(UserRequest data);
}
