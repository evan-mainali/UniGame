package org.example;

public class Item {

    String name;
    Room usedIn;
    public Item(String name, String description, Room usedIn, String usedText, String type, Object target) {
        this.name = name;
        this.usedIn = usedIn;
    }

    public String getName(){
        return name;
    }
    public Object getUsedIn(){
        return usedIn;
    }
}
