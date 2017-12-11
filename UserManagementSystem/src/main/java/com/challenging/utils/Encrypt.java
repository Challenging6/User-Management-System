package com.challenging.utils;

import org.apache.commons.codec.binary.Base64;

public class Encrypt {
    public static byte[] encryptBASE64(byte[] origin) {
        if (origin == null) {
            return null;
        }
        return Base64.encodeBase64(origin);
    }


    public static void main(String[] args){
        String a = new String(Encrypt.encryptBASE64("123456".getBytes()));
        System.out.println(a);
    }
}


