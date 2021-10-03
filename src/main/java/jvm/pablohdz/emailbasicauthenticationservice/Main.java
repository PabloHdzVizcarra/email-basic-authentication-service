package jvm.pablohdz.emailbasicauthenticationservice;

import jvm.pablohdz.emailbasicauthenticationservice.server.Server;

public class Main {
    public static void main(String[] args) {
        Server server = new Server(8080);

        server.createServer();
    }
}
