package org.example;

public class Map {

    private boolean running;
    Room startingRoom;
    Room r1;
    Room r2;
    Room r3;
    Room r4;
    Room r5;
    private Room currentRoom;
    private Player player;
    private Score score = new Score();
    private boolean hasEnteredR2 = false;
    public Map(Room startingRoom) {


        r1 = new Room("R1","The hallway");
        r2 = new Room("R2", "The Cargo Bay");
        r3 = new Room("R3","high-security science lab");
        r4 = new Room("R4","The Command Deck");
        r5 = new Room("R5","Escape pod bay");
        r1.setIsDark(true);
        r2.setIsDark(false);
        r3.setIsDark(true);
        r4.setIsDark(true);
        r5.setIsDark(true);
        startingRoom.setIsDark(false);

        r1.addItem(new Item("ITEM_SLOT_0", "A maintenance chip.", r3, "Slot 0 accepted.", "key", r3));
        r2.addItem(new Item("FLASHLIGHT", "A light which makes dark room bright.", null, "You turned the flashlight on.", "misc", null));
        r4.addItem(new Item("ITEM_SLOT_1", "An upper-deck override chip.", r5, "Slot 1 accepted.", "key", r5));
        r4.addNpc(new Npc("Commander", "Welcome to the command deck, the ship has crashed escape as quickly as possible"));


        startingRoom.addExit(new Exit("north", r1,false));
        startingRoom.addExit(new Exit("west", r3,true));
        startingRoom.addExit(new Exit("east", r2,false));


        r1.addExit(new Exit("south", startingRoom,false));
        r1.addExit(new Exit("north", r4,false));


        r2.addExit(new Exit("west", startingRoom,false));
        r2.addExit(new Exit("east", r5,true));


        r3.addExit(new Exit("east", startingRoom,false));

        // R4 connections
        r4.addExit(new Exit("south", r1,false));


        r5.addExit(new Exit("west", r2,false));

        // 4. Set the starting room and game status
        setRunning(true);
        currentRoom=startingRoom;
        this.startingRoom = startingRoom;
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
            score.deductScore();


        }
    }
    public void collectItem() {
        // Check if the current room actually has an item
        if (currentRoom.getItem() != null) {
            Item item = currentRoom.getItem();

            player.addToInv(item);
            System.out.println("Collected " + item.getName());
            System.out.println(item.getDescription());
            if(item.getType().equals("key")){
                System.out.println("Required to open "+item.getUsedIn().getRoomName());
            }
            currentRoom.removeItem(); //removes from room after it has been collected.

        } else {
            System.out.println("There is nothing to collect here.");
        }
    }

    public String getPlayerName(){
        return player.getName();
    }
    public String getPlayerInventory(){
        return player.getInventory();
    }


    public void useItem(String itemName) {

        Room inRoom = currentRoom;
        String itemNameUpperCase = itemName.toUpperCase();
        Item item = player.getItemByName(itemNameUpperCase);

        if (item == null) {
            System.out.println("Item not in inventory");
        } else {

            if (inRoom.getRoomName().equals("R0") && inRoom.getExit("west").isLocked() && item.getType().equals("key") && item.getUsedIn()==r3) {
                startingRoom.getExit("west").setLocked(false);
                System.out.println(item.getUsedText());
                score.addScore();


            }

            else if (inRoom.getRoomName().equals("R2") && inRoom.getExit("east").isLocked() && item.getType().equals("key") && item.getUsedIn()==r5) {

                r2.getExit("east").setLocked(false);
                System.out.println(item.getUsedText());
                score.addScore();

            }

            else if(item.getType().equals("misc") || item.getName().equalsIgnoreCase("Flashlight")){
                    System.out.println(item.getUsedText());
                    hasEnteredR2 = true;


            }

            else {
                System.out.println("You cant use that here");
            }
        }




    }

    public int getScore(){
        return score.getScore();
    }
    public boolean hasEnteredR2(){
        return hasEnteredR2;
    }

    public void setPlayer(Player player){
        this.player = player;
    }








}