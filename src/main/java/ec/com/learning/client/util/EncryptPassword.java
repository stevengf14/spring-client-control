package ec.com.learning.client.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Steven
 */
public class EncryptPassword {

    public static void main(String[] args) {
        var password = "admin";
        System.out.println("Password Before Encrypt: " + password);
        System.out.println("Password Before Encrypt: " + encrypt(password));
    }

    public static String encrypt(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);

    }

}
