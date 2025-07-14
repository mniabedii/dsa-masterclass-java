package com.github.mniabedii.redblacktree;

public enum NodeColor {
    RED("\u001B[41m"),
    BLACK("\u001B[40m");

    private final String color;

    NodeColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
