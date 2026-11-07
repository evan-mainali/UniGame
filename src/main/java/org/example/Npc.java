package org.example;

public class Npc {

    private String name;
    private String dialogue;

    public Npc(String name, String dialogue) {
        this.name = name.toLowerCase();
        this.dialogue = dialogue;
    }

    public String getDialogue(){
        return "Hello Traveller, my name is: "+name+" "+
                dialogue;
    }

    public String getName() {
        return name;
    }
}


