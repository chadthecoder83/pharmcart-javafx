package ui;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    void testEmptyUsername() {
        String username = "";
        assertTrue(username.isEmpty());
    }

    @Test
    void testNonEmptyPassword() {
        String password = "1234";
        assertFalse(password.isEmpty());
    }
}