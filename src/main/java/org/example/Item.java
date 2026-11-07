package org.example;


public class Item {

    private String name;
    private String description;
    private Room room;
    private String usedText;
    private String type;
    private Exit usedIn;

    public Item(String name, String description, Room room, String usedText, String type, Exit usedIn) {
        this.name = name;
        this.room = room;
        this.type = type;
        this.usedText = usedText;
        this.description=description;
        this.usedIn = usedIn;

    }

    public String getName(){
        return name.toLowerCase();
    }
    public Exit getUsedIn(){
        return usedIn;
    }

    public String getType() {
        return type;
    }

    public String getUsedText() {
        return usedText;
    }
    public Room getRoom(){
        return room;
    }

    public String getDescription(){return description;}

}
