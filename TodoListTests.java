//Name: Suhas Palawala
//Date: 12/3/2023

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.io.*;

// TODO Your JUnit testing code here!
public class TodoListTests {
    private TodoList testingList;

    @BeforeEach
    public void setUp() {
        testingList = new TodoList();
    }

    @Test
    public void testAddItem() {
        testingList.addItem("Homework Assignment", "");
        assertEquals(1, testingList.getSize());
        assertEquals("Homework Assignment", testingList.getValueAt(0));
        testingList.addItem("Homework Assignment1", "");
        assertEquals(2, testingList.getSize());
        assertEquals("Homework Assignment1", testingList.getValueAt(1));
    }

    @Test
    public void testMarkItemAsDone() {
        testingList.addItem("Homework Assignment", "");
        testingList.markItemAsDone("1");
        assertEquals(0, testingList.getSize());
        testingList.addItem("Homework Assignment1", "");
        testingList.addItem("Homework Assignment2", "");
        testingList.markItemAsDone("1");
        assertEquals(1, testingList.getSize());
        testingList.markItemAsDone("1");
        testingList.markItemAsDone("1");
        assertEquals(0, testingList.getSize());
    }

    @Test
    public void testLoadItems() throws FileNotFoundException {
        testingList.loadItems("LoadTasks.txt");
        assertEquals("Finish Math Homework", testingList.getValueAt(0));
        assertEquals("Finish Science Homework", testingList.getValueAt(1));
        assertEquals("Finish English Homework", testingList.getValueAt(2));
        assertEquals("Finish CSE Homework", testingList.getValueAt(3));
    }

    @Test
    public void testSaveItems() throws FileNotFoundException {
        testingList.loadItems("LoadTasks.txt");
        testingList.saveItems("SaveTasks.txt");
        Scanner readFile = new Scanner(new File("SaveTasks.txt"));
        assertEquals("Finish Math Homework", readFile.nextLine());
        assertEquals("Finish Science Homework", readFile.nextLine());
        assertEquals("Finish English Homework", readFile.nextLine());
        assertEquals("Finish CSE Homework", readFile.nextLine());
    }

    @Test
    public void testGetSize() {
        testingList.addItem("Homework Assignment", "");
        assertEquals(1, testingList.getSize());
        testingList.addItem("Homework Assignment1", "");
        assertEquals(2, testingList.getSize());
        testingList.markItemAsDone("1");
        assertEquals(1, testingList.getSize());
    }

    @Test
    public void testGetValueAt() {
        testingList.addItem("Homework Assignment", "");
        assertEquals("Homework Assignment", testingList.getValueAt(0));
    }
}