package com.flattery;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flattery.models.Wohnung;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BaseController {

    private Object data = null;

    protected void setData(Object data) {
        this.data = data;
    }

    protected String getResponse() {

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);

        if (data != null) {
            response.put("data", data);
        }

        return _object2JSON(response);
    }

    protected String getError(String message) {

        Map<String, Object> response = new HashMap<>();
        response.put("success", false);
        response.put("errorMessage", message);

        return _object2JSON(response);
    }

    protected String getError() {
        return getError("Internal Error.");
    }

    protected String _object2JSON(Object object) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);

        } catch (JsonProcessingException exc) {
            return "{\"success\":false,\"errorMessage\":\"Internal error.\"}";
        }
    }

    protected JsonNode _JSONParse(String json) throws IOException {
        ObjectMapper objectgmapper = new ObjectMapper();
        return objectgmapper.readTree(json);
    }

    protected static boolean _isReceived(JsonNode jsonNode, String fieldName) {
        return jsonNode.has(fieldName)
                && !jsonNode.get(fieldName).asText().equals("null")
                && !jsonNode.get(fieldName).asText().equals("undefined")
                && !jsonNode.get(fieldName).asText().equals("");
    }
}
