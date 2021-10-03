package jvm.pablohdz.emailbasicauthenticationservice;

import jvm.pablohdz.emailbasicauthenticationservice.controller.AuthControllerRegister;
import jvm.pablohdz.emailbasicauthenticationservice.server.Server;
import jvm.pablohdz.emailbasicauthenticationservice.service.UserService;
import jvm.pablohdz.emailbasicauthenticationservice.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        Server server = new Server(8080);

        UserService userService = new UserServiceImpl();

        AuthControllerRegister authControllerRegister = new AuthControllerRegister(userService);
        server.createServer();

        server.setupController(authControllerRegister);
    }
}
