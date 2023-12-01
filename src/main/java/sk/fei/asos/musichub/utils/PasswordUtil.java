package sk.fei.asos.musichub.utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {

    private static final String SALT = "$2a$12$FW0kJmau5PPD6Ix9eHLPFOmYCEsn8Nh.QS2bDCHfan/3Hd5JLs32e";

    public static String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, SALT);
    }

    public static boolean checkPass(String enteredPassword, String dbPassword) {
       return dbPassword.equals(hashPassword(enteredPassword));
    }
}
