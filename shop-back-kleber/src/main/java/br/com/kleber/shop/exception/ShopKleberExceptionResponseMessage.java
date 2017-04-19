package br.com.kleber.shop.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ShopKleberExceptionResponseMessage implements Serializable {

    private final String httpReasonPhrase;
    private final String message;

    @JsonCreator
    public ShopKleberExceptionResponseMessage(
            @JsonProperty("status") String httpReasonPhrase,
            @JsonProperty("message") String message) {
        this.httpReasonPhrase = httpReasonPhrase;
        this.message = message;
    }

    public String getHttpReasonPhrase() {
        return httpReasonPhrase;
    }

    public String getMessage() {
        return message;
    }
}
