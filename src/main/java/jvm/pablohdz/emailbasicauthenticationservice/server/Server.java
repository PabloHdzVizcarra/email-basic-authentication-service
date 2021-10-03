package jvm.pablohdz.emailbasicauthenticationservice.server;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {
    private HttpServer server;
    private final int port;

    public Server(int port) {
        this.port = port;
    }

    public void createServer() {
        try {
            server = HttpServer.create(new InetSocketAddress(port), 0);
            server.setExecutor(null);
            server.start();
            System.out.println("The server is on in port: " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setupController(HttpHandler controller) {
        server.createContext("/api/auth/register", controller);
    }
}
