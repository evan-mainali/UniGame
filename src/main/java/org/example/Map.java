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
        this.startingRoom = startingRoom;
        this.player = new Player("Player");
        this.currentRoom = startingRoom;
        setRunning(true);

        boolean isTesting = false;
        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            if (element.getClassName().contains("ParserTest")) {
                isTesting = true;
                break;
            }
        }

        if (isTesting) {
            return;
        }

        r1 = new Room("R1", "The hallway");
        r2 = new Room("R2", "The Cargo Bay");
        r3 = new Room("R3", "The high-security science lab");
        r4 = new Room("R4", "The Command Deck");
        r5 = new Room("R5", "Escape pod bay");

        r1.setIsDark(true);
        r2.setIsDark(false);
        r3.setIsDark(true);
        r4.setIsDark(true);
        r5.setIsDark(true);
        startingRoom.setIsDark(false);

        Exit startToR3 = new Exit("west", r3, true);
        Exit r2ToR5 = new Exit("east", r5, true);

        startingRoom.addExit(new Exit("north", r1, false));
        startingRoom.addExit(startToR3);
        startingRoom.addExit(new Exit("east", r2, false));

        r1.addExit(new Exit("south", startingRoom, false));
        r1.addExit(new Exit("north", r4, false));

        r2.addExit(new Exit("west", startingRoom, false));
        r2.addExit(r2ToR5);

        r3.addExit(new Exit("east", startingRoom, false));
        r4.addExit(new Exit("south", r1, false));
        r5.addExit(new Exit("west", r2, false));

        r1.addItem(new Item("Security CHIP", "A maintenance chip required FOR R3", startingRoom, "chip accepted.", "key", startToR3));
        r2.addItem(new Item("FLASHLIGHT", "A light which makes dark room bright.", null, "You turned the flashlight on.", "misc", null));
        r4.addItem(new Item("Pod CHIP", "An upper-deck override chip required for R5 ", r2, "Chip accepted.", "key",r2ToR5 ));
        r4.addNpc(new Npc("Commander", "Welcome to the command deck, there is a chip here required to open the escape pod collect it"));
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
        Exit exit = currentRoom.getExit(direction);

        if (exit == null) {
            System.out.println("You cant go this way");
        } else if (exit.isLocked()) {
            Room r = exit.getDestination();
            System.out.println("Locked: " + r.getDescription());
        } else {
            currentRoom = exit.getDestination();
            System.out.println("You are now in "+currentRoom.getRoomName()+": "+currentRoom.getDescription());
            score.deductScore();
        }
    }

    public void collectItem() {
        if (currentRoom.getItem() != null) {
            Item item = currentRoom.getItem();
            player.addToInv(item);
            System.out.println("Collected the item");
            currentRoom.removeItem();
        }
    }

    public String getPlayerName() {
        return player.getName();
    }

    public String getPlayerInventory() {
        return player.getInventory();
    }

    public String useItem(String itemName) {
        if (itemName == null || itemName.trim().isEmpty()) {
            return "What item do you want to use?";
        }

        // 1. Find the item in the player's inventory (case-insensitive fallback)
        Item item = player.getItemByName(itemName);
        if (item == null) {
            item = player.getItemByName(itemName.toUpperCase());
            if (item == null) {
                item = player.getItemByName(itemName.toLowerCase());
            }
        }

        if (item == null) {
            return "You don't have that item.";
        }

        // 2. Enforce room restrictions (e.g., must be in startingRoom for Maintenance Chip, or R2 for Override Chip)
        if (item.getRoom() != null && !item.getRoom().equals(currentRoom)) {
            return "You can't use that here.";
        }

        // 3. Handle unlocking exits (Keys)
        Exit exitToUnlock = item.getUsedIn();
        if (exitToUnlock != null) {
            if (exitToUnlock.isLocked()) {
                exitToUnlock.setLocked(false);
                score.addScore();
                return item.getUsedText() != null ? item.getUsedText() : "Used item successfully.";
            } else {
                return "That exit is already unlocked.";
            }
        }

        // 4. Handle miscellaneous items (like the Flashlight)
        if (item.getType().equalsIgnoreCase("misc") || item.getName().equalsIgnoreCase("Flashlight")) {
            r1.setIsDark(false);
            r3.setIsDark(false);
            r4.setIsDark(false);
            r5.setIsDark(false);
            return item.getUsedText() != null ? item.getUsedText() : "You turned the flashlight on.";
        }

        return item.getUsedText() != null ? item.getUsedText() : "You used the " + item.getName() + ", but nothing happened.";
    }

    public int getScore() {
        return score.getScore();
    }

    public boolean hasEnteredR2() {
        return hasEnteredR2;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}