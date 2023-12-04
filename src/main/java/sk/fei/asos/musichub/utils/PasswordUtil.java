package sk.fei.asos.musichub.utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {

    public static String genSalt(){
        return BCrypt.gensalt();
    }

    public static String hashPassword(String plainTextPassword, String salt) {
        return BCrypt.hashpw(plainTextPassword, salt);
    }

    public static boolean checkPass(String enteredPassword, String dbPassword, String salt) {
       return dbPassword.equals(hashPassword(enteredPassword, salt));
    }
}
