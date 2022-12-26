package com.github.avyarkov.MySpringDemo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Request {
    @JsonProperty
    String string;
    @JsonProperty
    int num;
    @JsonProperty
    boolean bool;

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
