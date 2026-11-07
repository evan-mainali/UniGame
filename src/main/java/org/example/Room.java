package org.example;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private String name;
    private String description;
    private Item item;
    private ArrayList<Exit> exits = new ArrayList<>();
    private Npc npc;
    private boolean isDark;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addExit(Exit exit) {
        exits.add(exit);
    }

    public void addItem(Item item) {
        this.item = item;
    }

    public void addNpc(Npc npc) {
        this.npc = npc;
    }

    public Exit getExit(String direction) {
        for (Exit exit : exits) {
            if (exit.getDirection().equalsIgnoreCase(direction)) {
                return exit;
            }
        }
        return null;
    }

    public ArrayList<Exit> getExits() {
        return exits;
    }

    public Item getItem() {
        return (item != null) ? item : null;
    }

    public void removeItem() {
        item = null;
    }

    public String getItemName() {
        return (item != null) ? item.getName() : null;
    }

    public String getRoomName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Npc getNpc() {
        return npc;
    }

    public boolean getIsDark() {
        return isDark;
    }

    public void setIsDark(boolean isDark) {
        this.isDark = isDark;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Room room = (Room) obj;
        return getRoomName() != null && getRoomName().equalsIgnoreCase(room.getRoomName());
    }


    public String toString() {
        String toString ="The exits are: \n";
        if(!(getIsDark())){
            for(Exit e:exits){
                toString+= e.getDirection()+" leading to "+e.getDestination().getRoomName() +" Which is "+e.getDestination().getDescription() +"\n";
            }
            if(getNpc()!=null && getItem()!=null){
                toString+="\n \n " +
                        "Here with you: "+getNpc().getName() +"\n "+"You can see "+getItem().getName();
            }
            else if(getNpc()!=null && getItem() ==null){
                toString+="\n \n " +
                        "Here with you: "+getNpc().getName() +"\n "+"You can see no items";
            }
            else if(getNpc()==null && getItem()!=null){
                toString+= "\n \n"+
                        "Here with you: "+"\n "+"You can see "+getItem().getName();
            }
            else{
                toString += "\n \n "+"No one here with you and no items here";
            }
            return toString;

        }
        else{
            for(Exit e:exits) {
                toString += e.getDirection() + " " + e.getDestination().getRoomName() + " Which is " + e.getDestination().getDescription() + "\n";
            }
            toString+="\n \n "+"Tyring using a flashlight to see rest of the information";
            return toString;
        }


    }


}