package org.example;

public class Exit {

    private Room destinaton;
    private String direction;
    private boolean islocked;

    public Exit(String direction, Room destination, boolean isLocked) {
        this.destinaton = destination;
        this.islocked = isLocked;
        this.direction = direction;
    }

    public boolean isLocked(){
        return islocked;
    }

    public Room getDestination(){
        return destinaton;
    }
    public String getDirection(){
        return direction;
    }

    public void setLocked(boolean isLocked){
        this.islocked = isLocked;
    }

}
