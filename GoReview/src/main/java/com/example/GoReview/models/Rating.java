package com.example.GoReview.models;

public enum Rating {
    COMPLETELY_DISSATISFIED(1),
    NOT_SATISFIED(2),
    AVERAGE(3),
    GOOD(4),
    EXCELLENT(5);

    private final int value;

    Rating(int value) {
        this.value=value;
    }

    public int getValue() {
        return value;
    }
}
