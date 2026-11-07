package org.example;

import java.util.ArrayList;

public class Player {

        private String name;
        ArrayList<Item> inventory= new ArrayList<>();

        public Player(String name){
            this.name = name;
        }

        public String getInventory(){

            String playerInv ="";
            for(Item i: inventory){
                playerInv += i.getName()+" ";
            }
            return "Inventory Contains: "+playerInv;
        }

        public String getName(){
            return name;
        }

        public void addToInv(Item item){
            inventory.add(item);
        }

        public ArrayList<String> getPlayerInvArray(){
            ArrayList<String> itemStrings = new ArrayList<>();
            for(Item i : inventory){
                itemStrings.add(i.getName());
            }
            return itemStrings;
        }

        public Item getItemByName(String item){
            item = item.trim();
            for(Item i:inventory){
                if(i.getName().equalsIgnoreCase(item)){
                    return i;
                }
            }
            return null;
        }




}
