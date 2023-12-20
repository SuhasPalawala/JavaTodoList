//Name: Suhas Palawala
//Date: 12/3/2023

import java.util.*;
import java.io.*;

/* This class allows the user to create a todo list of tasks they need to complete. They are able to 
    add tasks, mark them as done, load a todo list from a file, and even save their todo list to a file 
    of their choice.
*/
public class TodoList {
    // TODO: Your code here! 
    private List<String> thingsToDo;

    // Behavior: This method acts as a constructor for the TodoList class.
    public TodoList() {
         thingsToDo = new ArrayList<String>();
    }

    /*
    // Behavior: This method prints out the user's current todo list in a numbered fashion.
                If the user does not have any tasks in their todo list, then the method will simply 
                tell the user that they do not have anything in their list at the moment.

    // Exceptions: N/A

    // Returns: N/A

    // Parameters: N/A
    */
    public void printTodos() {
        // TODO: Your Code Here
        System.out.println("Today's TODOs:");
        if(thingsToDo.size() == 0) {
            System.out.println("  You have nothing to do yet today! Relax!");
        } else {
            int count = 1;
            for(int a = 0; a < thingsToDo.size(); a++) {
                System.out.println("  " + count + ": " + thingsToDo.get(a));
                count++;
            }
        }
    }

    /*
    // Behavior: This method adds the task the user would like to upload to their todo list
                to the list. The user has the option of just adding the task to the end of the list
                or specifying exactly where they want it to be. 

    // Exceptions: N/A

    // Returns: N/A

    // Parameters:  input1: the task the user would like to add
                    input2: where in the list the user would like to add a task to
    */
    public void addItem(String input1, String input2) {
        // TODO: Your Code Here
        
        if(thingsToDo.size() == 0) {
            thingsToDo.add(input1);
            printTodos();
        } else {
            if(input2.equals("")) {
                thingsToDo.add(input1);
                printTodos(); 
            } else {
                thingsToDo.add(Integer.parseInt(input2) - 1, input1);
                printTodos();
            }
        }
    }

    /*
    // Behavior: This method is meant to remove an item in the user's todo list if 
                they have finished it.

    // Exceptions: N/A

    // Returns: N/A

    // Parameters: input1: the task the user would like to mark as completed
    */
    public void markItemAsDone(String input1) {
        // TODO: Your Code Here
        if(thingsToDo.size() == 0) {
            System.out.println("All done! Nothing left to mark as done!");
            printTodos();
        } else {
            thingsToDo.remove(Integer.parseInt(input1) - 1);
            printTodos();
        }
    }

    /*
    // Behavior: This method takes in a file as input and then adds the tasks in that file
                to the user's todo list. 

    // Exceptions: FileNotFoundException: if the user enters a file that is not able to be located

    // Returns: N/A

    // Parameters: input1: the file the user would like to load items from
    */
    public void loadItems(String input1) throws FileNotFoundException {
        // TODO: Your Code Here
        Scanner content = new Scanner(new File(input1));
        thingsToDo.clear();

        while(content.hasNextLine()) {
            thingsToDo.add(content.nextLine());
        }
        printTodos();
    }

    /*
    // Behavior: This method takes the user's todo list and then prints out the tasks to 
                a file of the user's choice. 

    // Exceptions: FileNotFoundException: if the user enters a file that is not able to be located

    // Returns: N/A

    // Parameters: input1: the file the user would like to print their to-do list to
    */
    public void saveItems(String input1) throws FileNotFoundException {
        // TODO: Your Code Here
        PrintStream userFile = new PrintStream(new File(input1));
        printTodos();

        for(int a = 0; a < thingsToDo.size(); a++) {
            userFile.println(thingsToDo.get(a));
        }     
    }

    /*
    // Behavior: This method is meant to provide the size of the current to-do list.

    // Exceptions: N/A

    // Returns: int: the size of the to-do list

    // Parameters: N/A
    */
    public int getSize() {
        return thingsToDo.size();
    }

    /*
    // Behavior: This method is meant to provide the value of a certain index in the
    todo list for testing purposes.

    // Exceptions: N/A

    // Returns: int: the value of the specified index of the todo list

    // Parameters: N/A
    */
    public String getValueAt(int n) {
        return thingsToDo.get(n);
    }
}