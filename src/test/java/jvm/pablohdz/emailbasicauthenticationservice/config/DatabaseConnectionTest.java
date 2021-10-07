package jvm.pablohdz.emailbasicauthenticationservice.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DatabaseDataTest {
    private DatabaseData databaseData;

    @BeforeEach
    void setUp() {
        databaseData = new DatabaseData();
    }

    @Test
    void name() {
        String expectUrl = "mysql";

        String actualUrl = databaseData.getUrlDatabase();

        assertThat(actualUrl).isNotEmpty()
                .contains(expectUrl);
    }
}