package jvm.pablohdz.emailbasicauthenticationservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import jvm.pablohdz.emailbasicauthenticationservice.service.UserService;

public class AuthControllerRegister implements HttpHandler {
    private final UserService userService;



    public AuthControllerRegister(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void handle(HttpExchange exchange) {
        InputStream requestBody = exchange.getRequestBody();
        try {

            String body =
                    CharStreams.toString(new InputStreamReader(requestBody, Charsets.UTF_8));

            ObjectMapper objectMapper = new ObjectMapper();
            UserRequest user = objectMapper.readValue(body, UserRequest.class);

            userService.saveUser(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
