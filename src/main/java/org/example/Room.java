package org.example;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private String name;
    private String description;
    private Item item;
    private ArrayList<Exit> exits = new ArrayList<>(); // Store exits in a list
    private Npc npc;
    private boolean isDark;


    public Room(String name, String description) {
        this.name = name;
        this.description = description;


    }

    public void addExit(Exit exit) {
        exits.add(exit); // Save the exit to the list
    }

    public void addItem(Item item) {
        this.item = item;
    }

    public void addNpc(Npc npc) {
        this.npc = (npc);
    }

    // Method to get exit with direction
    public Exit getExit(String direction) {

        for (Exit exit : exits) {
            if (exit.getDirection().equalsIgnoreCase(direction)) {
                return exit;
            }
        }
        return null;

    }
    public ArrayList<Exit> getExits(){
        return exits;

    }


    public Item getItem() {
        return (item != null) ? item : null;
    }
    public void removeItem(){
      item = null;
    }
    public String getItemName(){
        return (item!=null)? item.getName():null;
    }


    public String getRoomName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Npc getNpc(){
        return npc;
    }

    public boolean getIsDark(){
        return isDark;
    }
    public void setIsDark(boolean isDark){
        this.isDark = isDark;
    }




}