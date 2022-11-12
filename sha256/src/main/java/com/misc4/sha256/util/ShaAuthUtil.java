package com.misc4.sha256.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class ShaAuthUtil {

    public static String getSha256Signature(String key, String data) {
        String algorithm = "HmacSHA256";
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), algorithm);
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(secretKeySpec);

            byte[] byteArray = mac.doFinal(data.getBytes());
            String hex = "";
            for (byte i : byteArray) {
                hex += String.format("%02x", i);
            }
            return hex;
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

}
