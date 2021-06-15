package org.launchcode.cheesemvc.Controllers.models;

public class Cheese {

    private String name;
    private String description;

    public Cheese(String name, String description) {
        this.name = name;  //field of the class not the method input
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
