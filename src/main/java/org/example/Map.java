package org.example;

public class Map {

    private boolean running;
    Room r0;
    Room r1;
    Room r2;
    Room r3;
    Room r4;
    Room r5;
    private Room currentRoom;
    private Player player;

    public Map(Player player) {

        r0 = new Room("R0","Starting Area");
        r1 = new Room("R1","The hallway with item slot 0");
        r2 = new Room("R2", "The Cargo Bay with an ITEM");
        r3 = new Room("R3","high-security science lab needing Item slot 0");
        r4 = new Room("R4","The Command Deck with an NPC and ITEM_SLOT_1");
        r5 = new Room("R5","Escape pod bay needing ITEM_SLOT_1");

        r1.addItem(new Item("ITEM_SLOT_0", "A maintenance chip.", r3, "Slot 0 accepted.", "key", r3));
        r2.addItem(new Item("ITEM", "A mysterious glowing component.", null, "You examine the item.", "misc", null));
        r4.addItem(new Item("ITEM_SLOT_1", "An upper-deck override chip.", r5, "Slot 1 accepted.", "key", r5));
        r4.addNpc(new Npc("Commander", "Hello traveler, find the chips to escape!"));

        // 3. Link room exits (connecting the map paths together)
        // R0 connections
        r0.addExit(new Exit("north", r1,false));
        r0.addExit(new Exit("west", r3,false));
        r0.addExit(new Exit("east", r2,false));

        // R1 connections
        r1.addExit(new Exit("south", r0,false));
        r1.addExit(new Exit("north", r4,false));

        // R2 connections
        r2.addExit(new Exit("west", r0,false));
        r2.addExit(new Exit("east", r5,false));

        // R3 connections (Locked door needing ITEM_SLOT_0)
        r3.addExit(new Exit("east", r0,true));

        // R4 connections
        r4.addExit(new Exit("south", r1,false));

        // R5 connections (Locked door needing ITEM_SLOT_1)
        r5.addExit(new Exit("west", r2,true));

        // 4. Set the starting room and game status
        setRunning(true);
        currentRoom=r0;
        this.player=player;
        }

        public boolean isRunning() {
            return running;
        }

        public void setRunning(boolean running) {
            this.running = running;
        }

        public Room getCurrentRoom() {
            return currentRoom;
    }

    public void movePlayer(String direction) {
        Room previousRoom = currentRoom;
        Exit exit = currentRoom.getExit(direction);


        if (exit == null) {
            System.out.println("You cant go this way");
        }

        else if (exit.isLocked()) {
            Room r = exit.getDestination();
            System.out.println("Locked: " + r.getDescription());
        }
        else {
            Room r = exit.getDestination();
            currentRoom = r;
            System.out.println("You moved from " + previousRoom.getRoomName() + " you are now in " + currentRoom.getRoomName());
            if (currentRoom.getNpc() != null) {
                System.out.println( currentRoom.getNpc().getDialogue());
            }


        }
    }
    public void collectItem(){
        System.out.println("Collected "+currentRoom.getItem());
    }
    public void addToPlayerInv(){
        Room room = currentRoom;
        if(room.getItem()!=null){
            player.addToInv(room.getItem());
        }

    }
    public String getPlayerName(){
        return player.getName();
    }
    public String getPlayerInventory(){
        return player.getInventory();
    }









}
