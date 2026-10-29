package org.example;

public class Npc {

    private String name;
    private String dialogue;

    public Npc(String name, String dialogue) {
        this.name = name;
        this.dialogue = dialogue;
    }

    public String getDialogue(){
        return dialogue+" My name is "+name;
    }



}
