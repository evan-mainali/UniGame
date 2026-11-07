package org.example;



public class Parser {

    public Parser() {
    }

    public String parse(Map map, String input) {
        if (input == null || input.trim().isEmpty()) {
            return "Please enter a command.";
        }
        input = input.trim().toLowerCase();

        // 1. Movement commands
        if (input.startsWith("move ")) {
            String direction = input.substring(5).trim();
            map.movePlayer(direction);
            return "";
        } else if (input.equals("north") || input.equals("south") || input.equals("east") || input.equals("west")) {
            map.movePlayer(input);
            return "";
        }

        else if (input.equals("look")) {
            Room r = map.getCurrentRoom();
            return r.toString();
        }
        else if (input.startsWith("look ")) {
            Room current = map.getCurrentRoom();
            String itemString = input.substring(5).trim();

            if (current.getIsDark()) {
                return "It is pitch black. There is nothing here";
            }

            Item item = current.getItem();
            if (item != null) {
                if(item.getName().equalsIgnoreCase(itemString)){
                    return item.getDescription();
                }
                else{
                    return "No description for this item";
                }
            }
            else{
                return "That item doesn't exist in this room";
            }
        }

        else if (input.equals("quit") || input.equals("exit")) {
            map.setRunning(false);
            return "Your score was " + map.getScore();
        }

        else if (input.startsWith("take ") || input.startsWith("get ")) {
            Room r = map.getCurrentRoom();

            if(!(r.getIsDark())) {
                if (r.getItem() != null) {
                    int cutoff = input.startsWith("take ") ? 5 : 4;
                    String item = input.substring(cutoff).trim();

                    if (r.getItem().getName().equalsIgnoreCase(item)) {
                        map.collectItem();
                        return "";
                    } else {
                        return "Not an item";
                    }
                }
                else {
                    return "No item here";
                }
            }
            else{
                return "Try getting a flashlight, can't see anything";
            }
        }
        // 5. Inventory command
        else if (input.equals("inventory") || input.equals("inv")) {
            return map.getPlayerInventory();
        }
        // 6. Score command
        else if (input.equals("score")) {
            return "Your score was " + map.getScore();
        }
        // 7. Talk command
        else if (input.startsWith("talk ")) {
            Room r = map.getCurrentRoom();
            if (r.getIsDark() && !map.hasEnteredR2()) {
                return "Too dark to see";
            }
            Npc npc = r.getNpc();

            // Handle both "talk <npc>" and "talk to <npc>"
            String target = input.substring(5).trim();
            if (target.startsWith("to ")) {
                target = target.substring(3).trim();
            }

            if (npc != null && target.equalsIgnoreCase(npc.getName())) {
                return npc.getDialogue();
            } else if (npc != null) {
                return "Please enter correct name";
            }
            return "There is no one here to talk to.";
        }
        // 8. Use / Activate command
        else if (input.startsWith("use ") || input.startsWith("activate ")) {
            String itemToUse = input.substring(input.indexOf(' ') + 1).trim();
            return map.useItem(itemToUse);
        } else if (input.equals("help")) {
            return "Available commands \n" +
                    "move <direction> or <direction>            Move north, west east and south    or    north west east south \n" +
                    "look                                       Describes the room you are in \n" +
                    "look <item>                                Inspects the item \n" +
                    "take/ get <item>                           Puts the item in the inventory \n" +
                    "talk <npc>                                 Displays the NPC dialogue \n" +
                    "score                                      Displays the current score \n" +
                    "help                                       Shows this list \n" +
                    "quit/exit                                  exits this game \n" +
                    "Inventory/inv                              To see inventory";

        }
        else {
            return "Unknown command.";
        }
    }
}
