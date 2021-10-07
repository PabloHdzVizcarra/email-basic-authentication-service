package jvm.pablohdz.emailbasicauthenticationservice.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import jvm.pablohdz.emailbasicauthenticationservice.controller.UserRequest;
import jvm.pablohdz.emailbasicauthenticationservice.service.Database;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserDaoTest {

    @Mock
    private Database database;
    private UserDao userDao;

    @BeforeEach
    void setUp() {
        userDao = new UserDao(database);
    }

    @Test
    void testThatCanSaveUser() {
        UserRequest user = createUser();
        long expectedId = 1L;
        when(database.create(any())).thenReturn(expectedId);

        long actualId = userDao.create(user);

        assertThat(actualId).isNotNull()
                .isEqualTo(expectedId);
    }

    private UserRequest createUser() {
        return new UserRequest("Tom", "Clancy", "Bravo",
                "example@test.com", "admin123"
        );
    }
}