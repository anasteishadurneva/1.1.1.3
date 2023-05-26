package com.bank.history.back.util;

import java.util.Objects;

public class Validations {

    public static void validateNotNull(Object value, String message) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateNotBlank(String value, String message) {
        if (Objects.isNull(value) || value.trim().isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    // Add more validation methods as needed
}