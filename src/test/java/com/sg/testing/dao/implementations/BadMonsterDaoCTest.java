package com.sg.testing.dao.implementations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sg.testing.dao.implementations.fixed.BadMonsterDaoC;
import com.sg.testing.model.Monster;
import com.sg.testing.model.MonsterType;

public class BadMonsterDaoCTest {

    BadMonsterDaoC testDao;

    @BeforeEach
    public void setUp() {
        testDao = new BadMonsterDaoC();
    }

    @Test
    public void testAddAndGetMonster() {

        Monster testMonster = new Monster("Vampire", MonsterType.VAMPIRE, 10, "Blood Bread");
        testDao.addMonster(1, testMonster);
        Monster obtainedMonster = testDao.getMonster(1);

        assertEquals(testMonster.getName(), obtainedMonster.getName(), "Test failed: testAddAndGetMonster, names different.");
        assertEquals(testMonster.getType(), obtainedMonster.getType(), "Test failed: testAddAndGetMonster, types different.");
        assertEquals(testMonster.getPeopleEaten(), obtainedMonster.getPeopleEaten(), "Test failed: testAddAndGetMonster, people eaten different.");
        assertEquals(testMonster.getFavoriteFood(), obtainedMonster.getFavoriteFood(), "Test failed: testAddAndGetMonster, favorite food different.");

    }

    @Test
    public void testGetAllMonsters() {
        Monster testMonsterOne = new Monster("Vampire", MonsterType.VAMPIRE, 10, "Blood Bread");
        Monster testMonsterTwo = new Monster("Swampthing", MonsterType.SWAMPTHING, 32, "Corpse Sandwich");
        testDao.addMonster(1, testMonsterOne);
        testDao.addMonster(2, testMonsterTwo);
        
        assertEquals(2, testDao.getAllMonsters().size(), "Test failed: testGetAllMonsters, size does not equal two");
    }

    @Test
    public void testUpdateMonster() {
        Monster testMonsterOne = new Monster("Vampire", MonsterType.VAMPIRE, 10, "Blood Bread");
        testDao.addMonster(1, testMonsterOne);        
        Monster testMonsterTwo = new Monster("Swampthing", MonsterType.SWAMPTHING, 32, "Corpse Sandwich");
        testDao.updateMonster(1, testMonsterTwo);
        Monster obtainedMonster = testDao.getMonster(1);

        assertEquals(testMonsterTwo.getName(), obtainedMonster.getName(), "Test failed: testUpdateMonster, names not equal.");
        assertEquals(testMonsterTwo.getType(), obtainedMonster.getType(), "Test failed: testUpdateMonster, types not equal.");
        assertEquals(testMonsterTwo.getPeopleEaten(), obtainedMonster.getPeopleEaten(), "Test failed: testUpdateMonster, people eaten not equal.");
        assertEquals(testMonsterTwo.getFavoriteFood(), obtainedMonster.getFavoriteFood(), "Test failed: testUpdateMonster, favorite food not equal.");
    }

    @Test
    public void testRemoveMonster() {
        Monster testMonster = new Monster("Vampire", MonsterType.VAMPIRE, 10, "Blood Bread");
        testDao.addMonster(1, testMonster); 

        Monster removedMonster = testDao.removeMonster(1);

        assertEquals(testMonster.getName(), removedMonster.getName(), "Test failed: testRemoveMonster, names different.");
        assertEquals(testMonster.getType(), removedMonster.getType(), "Test failed: testRemoveMonster, types different.");
        assertEquals(testMonster.getPeopleEaten(), removedMonster.getPeopleEaten(), "Test failed: testRemoveMonster, people eaten different.");
        assertEquals(testMonster.getFavoriteFood(), removedMonster.getFavoriteFood(), "Test failed: testRemoveMonster, favorite food different.");
        assertEquals(0, testDao.getAllMonsters().size(), "Test failed: testRemoveMonster, size does not equal zero");
    }
}