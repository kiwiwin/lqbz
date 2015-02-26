package com.thoughtworks.midas.user;

import redis.clients.jedis.Jedis;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.UUID;

public class App {
    public static void main(String[] args) {

        final SecureRandom secureRandom = new SecureRandom();

//        final String token = new BigInteger(130, secureRandom).toByteArray()

//        System.out.println(UUID.randomUUID().toString().getBytes());


//        final String s = Base64.getEncoder().encodeToString(new BigInteger(130, secureRandom).toByteArray());
//
//        System.out.println(s);
//        System.out.println(s.length());

        final String s2 = Base64.getEncoder().encodeToString(UUID.randomUUID().toString().getBytes());

//        System.out.println(s2);
//        System.out.println(s2.length());

        System.out.println(s2);

        final Jedis jedis = new Jedis("localhost");
        jedis.set(s2, "kiwi");
//        jedis.set(token, "kiwi");
//        System.out.println(token);
//        System.out.println(token.length());
//        System.out.println(jedis.get(token));
    }
}
