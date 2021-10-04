package jvm.pablohdz.emailbasicauthenticationservice.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRequestTest {

    @Test
    void testThatCreateTimestampWhenInstanceObject() {
        UserRequest userRequest = new UserRequest();

        assertNotNull(userRequest.getCreateAt());
    }
}