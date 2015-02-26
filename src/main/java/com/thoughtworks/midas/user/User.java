package com.thoughtworks.midas.user;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

public class User {
    private String username;
    private String phone;
    private String address;
    private Identity identity;

    User() {

    }

    public User(String username, String phone, String address, Identity identity) {
        this.username = username;
        this.phone = phone;
        this.address = address;
        this.identity = identity;
    }

    public String getUsername() {
        return username;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Identity getIdentity() {
        return identity;
    }

    public static void main(String[] args) throws IOException {
        final User user = new User("kiwi", "13011112222", "成都市成华区", new Identity("ID", "510100198801019909"));

        final String token = Base64.getEncoder().encodeToString(UUID.randomUUID().toString().getBytes());
        System.out.println(token);

        final ObjectMapper objectMapper = new ObjectMapper();

        final Jedis jedis = new Jedis("localhost");
        final String userJson = objectMapper.writeValueAsString(user);
        System.out.println(userJson);
        jedis.set(token, userJson);
        System.out.println(jedis.get("xxxsd"));
    }
}
