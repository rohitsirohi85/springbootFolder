package com.ProjectLinkedIn.user_service.utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {

    //hash the password for first time
    public static String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword,BCrypt.gensalt());
    }

    // check that password is matched
    public static boolean checkPassword(String plainTextPassword , String hashedPassword){
        return BCrypt.checkpw(plainTextPassword,hashedPassword);
    }

}
