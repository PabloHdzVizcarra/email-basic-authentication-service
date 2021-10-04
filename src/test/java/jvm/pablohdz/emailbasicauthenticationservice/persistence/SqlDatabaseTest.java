package jvm.pablohdz.emailbasicauthenticationservice.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jvm.pablohdz.emailbasicauthenticationservice.service.Database;

class SqlDatabaseTest {
    private Database underTest;

    @BeforeEach
    void setUp() {
        underTest = new SqlDatabase();
    }

    @Test
    void testThatCreateUser() {
        underTest.create();
    }
}