package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenListTest {
    private GenList<String> genTests;
    @BeforeEach
    void setup(){
        genTests = new GenList<>();
    }

    @Test
    void getFirst() {
        //test getFirst with empty list
        assertNull(genTests.getFirst());
        // test getFirst after add an item
        genTests.add("item1");
        assertNotNull(genTests.getFirst());
        assertEquals("item1", genTests.getFirst().getData());

    }

    @Test
    void isEmpty() {
        //test isEmpty
        assertTrue(genTests.isEmpty());
        // test isEmpty after adding an item
        genTests.add("item");
        assertFalse(genTests.isEmpty());
    }

    @Test
    void size() {
        //test size on an emty list
        assertEquals(0, genTests.size);
        // test size on a list containing 2 item
        genTests.add("item1");
        genTests.add("item2");
        assertEquals(2, genTests.size);

    }

    @Test
    void add() {
        assertEquals(0, genTests.size);
        // test size on a list containing  item
        genTests.add("item1");
        assertEquals(1, genTests.size);
        genTests.add("item2");
    }

    @Test
    void reset() {
        genTests.add("item1");
        genTests.add("item2");
        assertFalse(genTests.isEmpty());
        genTests.reset();
        assertTrue(genTests.isEmpty());
    }

    @Test
    void contains() {
        // on an empty list
        assertFalse(genTests.contains("item1"));
        genTests.add("item1");
        genTests.add("item2");
        assertTrue(genTests.contains("item1"));

    }

    @Test
    void remove() {
        // test that it contains when item1 is there
        genTests.add("item1");
        genTests.add("item2");
        assertTrue(genTests.contains("item1"));
        // test that item1 is removed
        genTests.remove("item1");
        assertFalse(genTests.contains("item1"));
    }
}