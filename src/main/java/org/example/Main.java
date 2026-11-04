package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Enter your name");
        Scanner nameInput = new Scanner(System.in);
        String name = nameInput.nextLine();
        Player player = new Player(name);
        Map map = new Map(player);
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