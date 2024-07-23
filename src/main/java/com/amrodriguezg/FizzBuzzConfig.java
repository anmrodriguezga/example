package com.amrodriguezg;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FizzBuzzConfig {
    int maxNumber = 1;

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public String getFizzBuzzList(int maxNumber) {
        if (maxNumber > 1) {
            setMaxNumber(maxNumber);
        }
        int maxValue = getMaxNumber();
        StringBuilder message = new StringBuilder();
        for (int i = 1; i <= maxValue; i++) {
            String valueMsg = "";
            if (i % 3 == 0) {
                valueMsg += "Fizz";
                if (i % 5 == 0) {
                    valueMsg += "Buzz";
                }
            } else if (i % 5 == 0) {
                valueMsg += "Buzz";
            } else {
                valueMsg += i;
            }
            message.append(valueMsg).append(", ");
        }

        return message.toString();
    }
}
