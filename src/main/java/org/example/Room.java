package org.example;

public class Room {

    private String name;
    Item item;
    public Room(String name, String description) {
        // TODO
    }

    public void addExit(Exit exit) {
        // TODO
    }

    public void addItem(Item item) {
        this.item = item;
    }

    public void addNpc(Npc npc) {
        // TODO
    }

    public boolean isLocked(boolean value){
        return value;
    }

    public String getItem(){
        return item.getName();
    }

    public String getRoomName(){
        return name;
    }
}
