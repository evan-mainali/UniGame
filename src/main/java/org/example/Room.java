package org.example;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private String name;
    private String description;
    private Item item;
    private List<Exit> exits = new ArrayList<>(); // Store exits in a list

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
        // TODO: Save NPC reference if needed
    }

    // Helper method to find an exit by direction
    public Exit getExit(String direction) {
        for (Exit exit : exits) {
            if (exit.getDirection().equalsIgnoreCase(direction)) {
                return exit;
            }
        }
        return null; // Return null if direction doesn't exist
    }

    public String getItem() {
        return (item != null) ? item.getName() : "No items here";
    }

    public String getRoomName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


}