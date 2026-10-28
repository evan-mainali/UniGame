package org.example;

public class Map {


    Room r0;
    Room r1;
    Room r2;
    Room r3;
    Room r4;
    Room r5;
    public Map(Room startingRoom) {
            // TODO
        }

        public Map() {

            r0 = new Room("R0","Starting Area");
            r1 = new Room("R1","The hallway with item slot 0");
            r2 = new Room("R2", "The Cargo Bay with an ITEM");
            r3 = new Room("R3","high-security science lab needing Item slot 0");
            r4 = new Room("R4","The Command Deck with an NPC and ITEM_SLOT_1");
            r5 = new Room("R5","Escape pod bay needing ITEM_SLOT_1");
        }

        public boolean isRunning() {
            // TODO
            return false;
        }

        public void setRunning(boolean running) {
            // TODO
        }

        public Room getCurrentRoom() {
            // TODO
            return null;
    }


}
