package com.flattery.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flattery.models.Favorite;

import java.io.IOException;

public class FavoriteMapper {

    public static Favorite readJsonWithObjectMapper(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, Favorite.class);
    }
}
