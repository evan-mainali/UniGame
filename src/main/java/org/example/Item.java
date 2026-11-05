package org.example;

public class Item {

    private String name;
    private Room usedIn;
    private Object target;
    private String usedText;
    private String type;

    public Item(String name, String description, Room usedIn, String usedText, String type, Object target) {
        this.name = name;
        this.usedIn = usedIn;
        this.target=target;
        this.type = type;
        this.usedText = usedText;
    }

    public String getName(){
        return name;
    }
    public Object getUsedIn(){
        return usedIn;
    }
    public Object getTarget(){return target;}

    public String getType() {
        return type;
    }

    public String getUsedText() {
        return usedText;
    }

}
