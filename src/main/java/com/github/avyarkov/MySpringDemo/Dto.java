package com.github.avyarkov.MySpringDemo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Dto<T> {
    @JsonProperty
    private String s;

    @JsonProperty
    private List<String> a;

    @JsonProperty
    private T b;

    public static <T> Dto<T> from(String s, List<String> a, T b) {
        Dto<T> dto = new Dto<>();
        dto.s = s;
        dto.a = a;
        dto.b = b;
        return dto;
    }

}
