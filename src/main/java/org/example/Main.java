package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("   WELCOME TO THE SPACE ADVENTURE GAME   ");
        System.out.println("=========================================");

        // Show starting room details
        Room current = map.getCurrentRoom();
        System.out.println("You are in: " + current.getRoomName());
        System.out.println(current.getDescription());

        // Main game loop
        while (map.isRunning()) {
            System.out.print("> ");
            String input = scanner.nextLine();

            // Parse the command and print the response
            String response = parser.parse(map, input);
            if (response != null && !response.isEmpty()) {
                System.out.println(response);
            }
        }

        scanner.close();
        System.out.println("Game Over. Thanks for playing!");
    }
}