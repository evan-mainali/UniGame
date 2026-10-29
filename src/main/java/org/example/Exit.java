package org.example;

public class Exit {

    private Room destinaton;
    private String direction;
    private boolean locked;

    public Exit(String direction, Room destination, boolean locked) {
        this.destinaton = destination;
        this.locked = locked;
        this.direction = direction;
    }

    public boolean isLocked(){
        return locked;
    }

    public Room getDestination(){
        return destinaton;
    }
    public String getDirection(){
        return direction;
    }

}
