package com.example.adam.dso.model;

public class Package {
    private Type type;
    private String theme;
    private String fileName;

    public Package() {
    }

    public Package(Type type, String theme, String fileName) {
        this.type = type;
        this.theme = theme;
        this.fileName = fileName;
    }

    public Type getType() {
        return type;
    }

    public String getTheme() {
        return theme;
    }

    public String getFileName() {
        return fileName;
    }
}
