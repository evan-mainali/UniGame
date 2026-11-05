package org.example;

import java.util.Scanner;

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
                    "\nVisible item: " + current.getItemName();
        }

        // 3. Handle Quitting the Game
        else if (input.equals("quit") || input.equals("exit")) {
            map.setRunning(false);
            System.out.println("Your score was "+map.getScore());
            return "Shutting down ship systems. Goodbye!";
        }
        else if(input.equals("take") || input.equals("get")){
            map.collectItem();
            return"";
        }
        else if(input.equals("inventory")){
            return map.getPlayerInventory();

        }
        else if(input.equals("score")){
            System.out.println(map.getScore());
            return "";
        }
        else if(input.equals("use")){
            System.out.println("Enter Item name to use:");
            Scanner useString = new Scanner(System.in);
            String useText = useString.next();
            useText = useText.trim().toLowerCase();
            map.useItem(useText);
            return "";
        }


        else {
            return "Unknown command. To move try typing 'north', 'south', 'east', 'west', For info on the room try typing 'look', "+
                    "'To collect an item try typing get/take',To see your inventory try typing 'inventory', " +
                    "To use an item try typing 'use' ,or 'quit/exit'. to quit the game ";
        }
    }
}