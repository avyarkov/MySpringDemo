package com.github.avyarkov.MySpringDemo;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@SuppressWarnings("unused")
@JsonPropertyOrder({"status", "data", "string", "warnings"})
public class Dto<T> {
    public enum Status {SUCCESS, ERROR}

    private final Status status;

    @JsonGetter("status")
    private String statusAsString() {
        return switch (status) {
            case SUCCESS -> "success";
            case ERROR -> "error";
        };
    }

    @JsonProperty
    private T data;

    @JsonProperty
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> warnings;

    @JsonProperty
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String string;

    public Dto(Status status, T data, String string, List<String> warnings) {
        this.status = status;
        this.data = data;
        this.string = string;
        this.warnings = warnings;
    }

    public static <T> Dto<T> success(T data, String string, List<String> warnings) {
        return new Dto<>(Status.SUCCESS, data, string, warnings);
    }
}
