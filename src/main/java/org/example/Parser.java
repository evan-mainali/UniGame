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


        if (input.startsWith("move ")) {
            String direction = input.substring(5).trim();
            if (direction.equals("north") || direction.equals("south") || direction.equals("east") || direction.equals("west")) {
                map.movePlayer(direction);
                return "";
            }
            else {
                return "Unknown direction. Please try moving north, south, east, or west.";
            }
        }
        else if (input.equals("north") || input.equals("south") || input.equals("east") || input.equals("west")) {
            map.movePlayer(input);
            return "";
        }
        else if (input.equals("look") || input.equals("look item")) {
                Room current = map.getCurrentRoom();

                // Otherwise, handle regular room description & darkness
            if (current.getIsDark() && !map.hasEnteredR2()) {
                return "It is pitch black. You cannot see a thing!";
            } else {
                if (input.startsWith("look ")) {
                    String itemText = (current.getItemName() != null) ? "\nVisible Item: " + current.getItemName() : "Visible item: " + null;
                    return itemText;
                } else {
                    return current.getDescription();
                }
            }
        }

            // 3. Handle Quitting the Game
        else if (input.equals("quit") || input.equals("exit")) {
            map.setRunning(false);
            System.out.println("Your score was " + map.getScore());
            return "Shutting down ship systems. Goodbye!";
        } else if (input.equals("take") || input.equals("get")) {
            Room r = map.getCurrentRoom();
                if (r.getIsDark() && map.hasEnteredR2()) {
                    map.collectItem();
                    return "";
                } else if (r.getRoomName().equals("R2")) {
                    map.collectItem();
                    return "";
                } else {
                    return "It is too dark to see";
                }
            } else if (input.equals("inventory")) {
                return map.getPlayerInventory();
            } else if (input.equals("score")) {
                System.out.println(map.getScore());
                return "";

            } else if (input.equals("talk")) {
                Room r = map.getCurrentRoom();
                if (r.getNpc() != null && r.getIsDark() && map.hasEnteredR2()) {
                    return r.getNpc().getDialogue();
                } else if (r.getNpc() != null && r.getIsDark() && !(map.hasEnteredR2())) {
                    return "Sorry it is too dark here to see";
                } else if (r.getIsDark() && r.getNpc() == null && map.hasEnteredR2()) {
                    return "Sorry, cannot use that command here as there are no NPCs.";
                } else {
                    return "Too dark to see";
                }
            } else if (input.startsWith("use ")) {
                String itemToUse = input.substring(4).trim();
                map.useItem(itemToUse);
                return "";
            } else {
                return "Unknown command. To move try typing 'north', 'south', 'east', 'west', For info on the room try typing 'look', " +
                        "'To collect an item try typing get/take',To see your inventory try typing 'inventory', " +
                        "To use an item try typing 'use' ,or 'quit/exit' to quit the game.";
            }
    }

}