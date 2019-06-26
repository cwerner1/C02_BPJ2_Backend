package com.flattery.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flattery.models.Wohnung;

import java.io.IOException;

public class WohnungMapper {

    public static Wohnung readJsonWithObjectMapper(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, Wohnung.class);
    }
}
