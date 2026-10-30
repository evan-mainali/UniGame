package org.example;

public class Parser {

    public Parser() {
    }

    public String parse(Map map, String input) {
        if (input == null || input.trim().isEmpty()) {
            return "Please enter a command.";
        }


        input = input.trim().toLowerCase();


        if (input.equals("north") || input.equals("south") || input.equals("east") || input.equals("west")) {
            map.movePlayer(input);
            return "";
        }


        else if (input.equals("look")) {
            Room current = map.getCurrentRoom();
            return "You are in " + current.getRoomName() + ". " + current.getDescription() +
                    "\nVisible item: " + current.getItem();
        }

        // 3. Handle Quitting the Game
        else if (input.equals("quit") || input.equals("exit")) {
            map.setRunning(false);
            return "Shutting down ship systems. Goodbye!";
        }
        else if(input.equals("collect")){
            map.collectItem();
            map.addToPlayerInv();
            return"";
        }
        else if(input.equals("see")){
            return map.getPlayerInventory();

        }


        else {
            return "Unknown command. Try typing 'north', 'south', 'east', 'west', 'look', 'collect' 'see',or 'quit'.";
        }
    }
}