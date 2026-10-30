package org.example;

import java.util.ArrayList;

public class Player {

        private String name;
        ArrayList<String> inventory = new ArrayList<>();

        public Player(String name){
            this.name = name;
        }

        public String getInventory(){

            String playerInv ="Inventory Contains: ";
            for(String i: inventory){
                playerInv = i+" ";
            }
            return playerInv;
        }

        public String getName(){
            return name;
        }

        public void addToInv(String item){
            inventory.add(item);
        }




}
