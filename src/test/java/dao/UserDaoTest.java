package dao;

import database.DatabaseInitializer;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserDaoTest {

    private UserDao userDao;

    @BeforeEach
    void setUp() {
        DatabaseInitializer.initializeDatabase();
        userDao = new UserDao();
        userDao.insertUser(new User("testuser", "password123", "user"));
    }

    @Test
    void testAuthenticateValidUser() {
        User user = userDao.authenticateUser("testuser", "password123");
        assertNotNull(user);
        assertEquals("user", user.getRole());
    }

    @Test
    void testAuthenticateInvalidUser() {
        User user = userDao.authenticateUser("wrong", "wrong");
        assertNull(user);
    }
}