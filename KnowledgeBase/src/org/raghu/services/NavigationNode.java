package org.raghu.services;

public class NavigationNode {

    private String description;
    private String contentLocation;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContentLocation() {
        return contentLocation;
    }

    public void setContentLocation(String contentLocation) {
        this.contentLocation = contentLocation;
    }
    
    public NavigationNode(String description, String location) {
        setDescription(description);
        setContentLocation(location);
    }
    
    public String toString() {
        return this.description;
    }

}
