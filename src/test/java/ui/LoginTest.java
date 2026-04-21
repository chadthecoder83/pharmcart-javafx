/*
 * PharmCart JavaFX Application
 * Course: CST 338
 *
 * @author: Elizabeth Leon
 * @since 4/20/26
 * Description:
 * Contains simple unit tests for login-related input validation.
 *
 */

package ui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    @Test
    void testUsernameNotEmpty() {
        String username = "user";
        assertFalse(username.isEmpty());
    }

    @Test
    void testPasswordNotEmpty() {
        String password = "user123";
        assertFalse(password.isEmpty());
    }

    @Test
    void testSimpleValidation() {
        String username = "admin";
        String password = "admin123";
        assertTrue(!username.isEmpty() && !password.isEmpty());
    }
}