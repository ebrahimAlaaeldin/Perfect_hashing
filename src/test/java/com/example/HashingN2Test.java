package com.example;
<<<<<<< HEAD

import static org.junit.Assert.*;
import static org.junit.Assume.assumeNoException;
=======
import static org.junit.Assert.*;
import static org.junit.Assume.assumeNoException;

import java.util.Random;

>>>>>>> 4f955be1f85a0188bddf44fa82ee2f30fd4a7b3c
import org.junit.Test;

public class HashingN2Test {

<<<<<<< HEAD
   
    @Test
    public void InsertTest()
    {
        HashingN2<String> h = new HashingN2<>(Long.MAX_VALUE, 6000);
        int testSize = 5000;
        try {
            for (int i = 0; i < testSize; i++)
                assertEquals("Inserted successfully", h.insert(new Generator().generateString()));
        } catch (Exception e) {
            assumeNoException(e);
        }
        assertEquals(testSize, h.getCount());
    }
    
    @Test
    public void SearchTest()
    {
        HashingN2<String> h = new HashingN2<>(Long.MAX_VALUE, 6000);
        String[] keys = new String[3000];
        try {
            for (int i = 0; i < 3000; i++) {
                keys[i] = new Generator().generateString();
                h.insert(keys[i]);
            }
            System.out.println(h.getCount());
            for (String key : keys) {
                System.out.println("Searching for " + key);
                assertTrue(h.search(key));
            }
            for (int i = 0; i < 3000; i++) {
                Generator gen = new Generator();
                String str = gen.generateString();
                if (gen.checkPresence(keys, str))
=======
    @Test
    public void InsertTest()
    {
        HashingN2<String> h = new HashingN2<>(Integer.MAX_VALUE ,6000);
        int testSize = 5000;
        try {
            for (int i = 0; i < testSize; i++)
            //assertTrue(h.insert(new Generator().generateString()));\
            assertEquals("Inserted successfully", h.insert(new Generator().generateString()));
        } catch (Exception e) {
            assumeNoException(e);
        }
    }

    @Test
    public void SearchTest()
    {
        HashingN2<String> h = new HashingN2<>(Integer.MAX_VALUE ,6000);
        int testSize = 5000;
        String[] keys = new String[testSize];
        try {
            for (int i = 0; i < testSize; i++) {
                keys[i] = new Generator().generateString();
                h.insert(keys[i]);
            }
            System.out.println(h.count);

            for (String key : keys) {

                System.out.println("Searching for " + key);
                assertTrue(h.search(key));

            }
            for (int i = 0; i < testSize; i++) {
                Generator gen = new Generator();
                String str = gen.generateString();
                if(gen.checkPresence(keys, str))
>>>>>>> 4f955be1f85a0188bddf44fa82ee2f30fd4a7b3c
                    continue;
                System.out.println("Searching for " + keys[i]);
                assertFalse(h.search(str));
            }
<<<<<<< HEAD
=======

        } catch (Exception e) {
            assumeNoException(e);
        }
    }

    @Test
    public void DeleteTest()
    {
        HashingN2<String> h = new HashingN2<>(Integer.MAX_VALUE ,6000);
        int testSize = 5000;
        String[] keys = new String[testSize];
        try {
            for (int i = 0; i < testSize; i++) {
                keys[i] = new Generator().generateString();
                h.insert(keys[i]);
            }
            System.out.println(h.count);

            for (String key : keys) {

                System.out.println("Deleting " + key);
                assertEquals("Deleted successfully", h.delete(key));

            }
            for (int i = 0; i < testSize; i++) {
                Generator gen = new Generator();
                String str = gen.generateString();
                if(gen.checkPresence(keys, str))
                    continue;
                System.out.println("Deleting " + keys[i]);
                assertEquals("Element not found", h.delete(str));
            }

>>>>>>> 4f955be1f85a0188bddf44fa82ee2f30fd4a7b3c
        } catch (Exception e) {
            assumeNoException(e);
        }
    }
    
<<<<<<< HEAD
    @Test 
    public void DeleteTest()
    {
        HashingN2<String> h = new HashingN2<>(Long.MAX_VALUE, 6000);
        int testSize = 1000;
        
        String[] str = new String[testSize];
        
        try {
            for (int i = 0; i < testSize; i++){
                 str[i] = new Generator().generateString();
                assertEquals("Inserted successfully", h.insert(str[i]));
            }
            for (int i = 0; i < testSize; i++)
                assertEquals("Deleted successfully", h.delete(str[i]));
        } catch (Exception e) {
            assumeNoException(e);
        }
        assertEquals(0, h.getCount());
    }

 
}
=======
}
>>>>>>> 4f955be1f85a0188bddf44fa82ee2f30fd4a7b3c