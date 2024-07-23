package com.amrodriguezg;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingConfig {
    String receipient = "LinkedIn Learning Students";

    public String getReceipient() {
        return receipient;
    }

    public void setReceipient(String receipient) {
        this.receipient = receipient;
    }
}
