package com.example.Dictionary;

import com.example.HashTableADT.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DictionaryNSpace implements Dictionary{
    private HashingN<String> hash;



    public DictionaryNSpace(int sizeOfPrimaryTable) {
        this.hash = new HashingN<>(sizeOfPrimaryTable);
    }
    public ArrayList<String> readWordsFromFile(String filePath) {
        ArrayList<String> wordsList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                wordsList.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
            // You can handle the exception here, like logging or throwing a custom exception
            throw new RuntimeException("Error reading file");
        }

        return wordsList;
    }

    public void batchInsert(String filePath) {
        ArrayList<String> words = readWordsFromFile(filePath);
        int totalInsertedElements = 0;
        int totalDuplicateElements = 0;
        for (String word : words) {
            String message = hash.insert(word);
            if(message.equals("Inserted successfully")){
                totalInsertedElements++;
            }
            else if(message.equals("Already exists in the table")){
                totalDuplicateElements++;
            }
        }
        System.out.println("\u001B[32m\nTotal Inserted Elements: " + totalInsertedElements + "\u001B[0m");
        System.out.println("\u001B[31mTotal Duplicate Elements: " + totalDuplicateElements + "\u001B[0m");
    }
    public void batchDelete(String filePath) {
        ArrayList<String> words = readWordsFromFile(filePath);
        int totalDeletedElements = 0;
        int totalNotFoundElements = 0;
        for (String word : words) {
            String message = hash.delete(word);
            if(message.equals("Deleted successfully")){
                totalDeletedElements++;
            }
            else if(message.equals("Element not found")){
                totalNotFoundElements++;
            }
        }
        System.out.println("\u001B[32m\nTotal Deleted Elements: " + totalDeletedElements + "\u001B[0m");
        System.out.println("\u001B[31mTotal Not Found Elements: " + totalNotFoundElements + "\u001B[0m");
    }

    public String insert(String word) {
        return hash.insert(word);
    }
    public boolean search(String word) {
        return hash.search(word);
    }

    public String delete(String word) {
        return hash.delete(word);
    }

    public int getNumberofCuurrentElementsinTable() {
        return hash.getCount();
    }

    public int getCollisions() {
        return hash.getInnerCollisions();
    }

    public boolean validateDeletion(String word) {
        return hash.validateDeletion(word);
    }

    public void display() {
        hash.print();
    }



}
