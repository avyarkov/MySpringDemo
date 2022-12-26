package com.github.avyarkov.MySpringDemo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Request {
    @JsonProperty
    String string;
    @JsonProperty
    int num;

    @JsonProperty
    boolean bool;
    @JsonSetter
    private void setBool(String string) {
        bool = string.equals("realTrue");
    }

    @Override
    public String toString() {
        return "Request{" +
            "string='" + string + '\'' +
            ", num=" + num +
            ", bool=" + bool +
            '}' +
            "\n" + (string == null);
    }
}
