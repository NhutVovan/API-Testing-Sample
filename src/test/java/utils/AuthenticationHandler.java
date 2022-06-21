package utils;

import org.apache.commons.codec.binary.Base64;

public class AuthenticationHandler {
    public static String encodedCredStr (String email, String token){
        if(email == null || token == null){
            throw new RuntimeException("Email or Token can't be null!");
        }
        String credit = email.concat(":").concat(token);
        byte[] encodeCredit = Base64.encodeBase64(credit.getBytes());
        return new String(encodeCredit);
    }
}