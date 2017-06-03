package com.eduit.ws.model;

/**
 * Created by Marcelo on 13/02/2017.
 */
public class LoginResponse {

    private String hash;

    public LoginResponse(String hash) {
        this.hash = hash;
    }

    public LoginResponse() {
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
