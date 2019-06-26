package com.flattery.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flattery.models.User;

import java.io.IOException;

public class UserMapper {

    public static User readJsonWithObjectMapper(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, User.class);
    }
}
