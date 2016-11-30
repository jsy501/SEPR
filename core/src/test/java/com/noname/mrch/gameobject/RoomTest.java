package com.noname.mrch.gameobject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Room Unit tests
 */
public class RoomTest {
    Room testRoom;
    GameCharacter testCharacter;
    Clue testClue;
    Item testItem;


    @Before
    public void setUp() throws Exception {
        testRoom = new Room(0, "test room", false);

        testCharacter = new GameCharacter();
        testClue = new Clue();
        testItem = new Item();

    }

    @After
    public void tearDown() throws Exception {
        testRoom = null;
        testCharacter = null;
        testClue = null;
        testItem = null;
    }
    @Test
    public void addCharacter() throws Exception {
        assertFalse(testRoom.getCharacterList().contains(testCharacter, true));

        testRoom.addCharacter(testCharacter);

        assertTrue(testRoom.getCharacterList().contains(testCharacter, true));
    }

    @Test
    public void getCharacterList() throws Exception {
        assertNotNull(testRoom.getCharacterList());

    }

    @Test
    public void addItem() throws Exception {
        assertFalse(testRoom.getItemList().contains(testItem, true));

        testRoom.addItem(testItem);

        assertTrue(testRoom.getItemList().contains(testItem, true));

    }

    @Test
    public void addClue() throws Exception {
        assertFalse(testRoom.getClueList().contains(testClue, true));

        testRoom.addClue(testClue);

        assertTrue(testRoom.getClueList().contains(testClue, true));

    }

    @Test
    public void getItemList() throws Exception {
        assertNotNull(testRoom.getItemList());
    }

    @Test
    public void getClueList() throws Exception {
        assertNotNull(testRoom.getClueList());
    }

    @Test
    public void removeClue() throws Exception {
        assertFalse(testRoom.getClueList().contains(testClue, true));

        testRoom.addClue(testClue);

        assertTrue(testRoom.getClueList().contains(testClue, true));

        testRoom.removeClue(testClue);

        assertFalse(testRoom.getClueList().contains(testClue, true));
    }

    @Test
    public void removeItem() throws Exception {
        assertFalse(testRoom.getItemList().contains(testItem, true));

        testRoom.addItem(testItem);

        assertTrue(testRoom.getItemList().contains(testItem, true));

        testRoom.removeItem(testItem);

        assertFalse(testRoom.getItemList().contains(testItem, true));
    }

    @Test
    public void getId() throws Exception {
        assertEquals("failure - id is not 0", 0, testRoom.getId());
    }

    @Test
    public void getName() throws Exception {
        assertEquals("failure - name is not 'test name'", "test name", testRoom.getName());
    }

}