package com.flattery;

import com.flattery.models.Wohnung;

import java.util.Optional;

public class BaseController {


    private Object data;

    protected void setData(Optional data) {
        this.data = data;

    }

    protected String getResponse() {
        return this.data.toString();
    }
}
