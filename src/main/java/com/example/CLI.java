package com.example;

import com.example.Dictionary.*;


import java.util.Objects;
import java.util.Scanner;

public class CLI {
    @SuppressWarnings("resource")
    public static String welcome() {
        System.out.println("Welcome to Your Dictionary CLI!");
        System.out.println("--------------------------------");
        System.out.println("Please choose one of the following options:");
        System.out.println("1. Dictionary Of O(N) Space");
        System.out.println("2. Dictionary Of O(N²) Space");
        Scanner sc = new Scanner(System.in);
        do {
            String choice = sc.nextLine();
            if ((choice.equals("1")) || (choice.equals("2"))) {
                return choice;
            }
            System.out.println("Invalid choice. Please try again.\n");
            System.out.println("Please choose one of the following options:");
            System.out.println("1. Dictionary Of O(N) Space.");
            System.out.println("2. Dictionary Of O(N²) Space.");
        } while (true);
    }

        @SuppressWarnings("resource")
    public static void menu(Dictionary dictionary) {

        do {
            System.out.println("\u001B[36mPlease choose one of the following options:\u001B[0m");
            System.out.println("1. Insert a word");
            System.out.println("2. Search for a word");
            System.out.println("3. Delete a word");
            System.out.println("4. Batch Insert from file");
            System.out.println("5. Batch Delete from file");
            System.out.println("6. Exit");
            Scanner sc = new Scanner(System.in);
            String choice = sc.nextLine();
            switch (choice) {
                case "1"://insert
                    System.out.println("Please enter the word you want to insert:");
                    String word = sc.nextLine();
                    System.out.println(word+" "+dictionary.insert(word)+"\n");
                    System.out.println("Number of collisions till now: "+dictionary.getCollisions());
                    System.out.println("Number of Current Elements in Table: "+dictionary.getNumberofCuurrentElementsinTable()+"\n");
                    break;
                case "2"://search
                    System.out.println("Please enter the word you want to search for:");
                    word = sc.nextLine();
                    if(dictionary.search(word)){
                        System.out.println("Good:) The Word: "+word+" was found.\n");
                    }else{
                        System.out.println("The Word: "+word+" is not found!!!\n");
                    }
                    break;
                case "3"://delete
                    System.out.println("Please enter the word you want to delete:");
                    word = sc.nextLine();
                    System.out.println(word+" "+dictionary.delete(word)+"\n");
                    System.out.println("Number of Current Elements in Table: "+dictionary.getNumberofCuurrentElementsinTable()+"\n");
                    break;
                case "4"://batch insert
                    System.out.println("Please provide the path for the file containing words to insert.");
                    String filePath = sc.nextLine();
                    dictionary.batchInsert(filePath);
                    System.out.println("\nBatch Insertion Done Successfully.\n");
                    System.out.println("Number of collisions till now: "+dictionary.getCollisions());
                    System.out.println("Number of Current Elements in Table: "+dictionary.getNumberofCuurrentElementsinTable()+"\n");
                    break;
                case "5"://batch delete
                    System.out.println("Please provide the path for the file containing words to delete.");
                    filePath = sc.nextLine();
                    dictionary.batchDelete(filePath);
                    System.out.println("\nBatch Deletion Done Successfully.\n");
                    System.out.println("Number of Current Elements in Table: "+dictionary.getNumberofCuurrentElementsinTable()+"\n");
                    break;
                case "6"://exit
                    System.exit(0);

                    break;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }
        while (true);
    }
    public static void  main(String[] args) {
        String dictionaryChoice = welcome();
        if (Objects.equals(dictionaryChoice, "1")) {//chose O(N) dictionary
            System.out.println("You have chosen Dictionary Of O(N) Space.\n");
            Dictionary dictionary = new DictionaryNSpace(16);
            menu(dictionary);
        } else {//chose O(N²) dictionary
            System.out.println("You have chosen Dictionary Of O(N²) Space.\n");
            //initialize N² dictionary
            Dictionary dictionary = new DictionaryN2Space(16);
            menu(dictionary);
        }


    }
}
