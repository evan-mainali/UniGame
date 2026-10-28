package org.example;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {



        Scanner input = new Scanner(System.in);
        String command = input.next();
        Map map = new Map();
        Parser parse = new Parser();
        parse.parse(map,command);

        System.out.println(parse);



        



    }

  








}