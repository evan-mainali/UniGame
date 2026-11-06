package org.example;

public class Item {

    private String name;
    private Room usedIn;
    private Room target;
    private String usedText;
    private String type;
    private String description;

    public Item(String name, String description, Room usedIn, String usedText, String type, Room target) {
        this.name = name;
        this.usedIn = usedIn;
        this.target=target;
        this.type = type;
        this.usedText = usedText;
        this.description=description;

    }

    public String getName(){
        return name;
    }
    public Room getUsedIn(){
        return usedIn;
    }
    public Room getTarget(){return target;}

    public String getType() {
        return type;
    }

    public String getUsedText() {
        return usedText;
    }

    public String getDescription(){return description;}

}
