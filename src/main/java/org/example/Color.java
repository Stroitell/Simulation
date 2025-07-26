package org.example;

public enum Color {
    RESET("\u001B[0m"),
    RED("\u001B[31m"),
    GREEN ("\u001B[32m"),
    BLUE ("\u001B[34m");

    private final String color;
    Color(String color) {
        this.color = color;
    }
    public String getColor(){
        return color;
    }
}
