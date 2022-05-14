package model;

import java.io.File;

public class Beverage {
    private String name;
    private File description;
    private File picture;
    private File list;

    public Beverage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getDescription() {
        return description;
    }

    public void setDescription(File description) {
        this.description = description;
    }

    public File getPicture() {
        return picture;
    }

    public void setPicture(File picture) {
        this.picture = picture;
    }

    public File getList() {
        return list;
    }

    public void setList(File list) {
        this.list = list;
    }
}
