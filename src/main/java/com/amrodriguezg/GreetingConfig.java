package com.amrodriguezg;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingConfig {
    String recipient = "LinkedIn Learning Students";

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}
