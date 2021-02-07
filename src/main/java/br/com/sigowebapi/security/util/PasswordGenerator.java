package br.com.sigowebapi.security.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
        System.out.println(encode);
    }
}