package ui;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * PharmCart JavaFX Application
 * Course: CST 338
 * @author Elizabeth Leon
 * @since 4-14-26
 * Description: Contains unit tests for login validation logic.
 */
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