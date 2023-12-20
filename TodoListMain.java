//Name: Suhas Palawala
//Date: 12/3/2023

import java.util.*;
import java.io.*;

/*
This class interacts with the client and prompts them for actions to perform on 
the todo list. 
*/
public class TodoListMain {
    public static void main(String[] args) throws FileNotFoundException {
        // TODO: Your code here!
        TodoList newList = new TodoList();

        Scanner userTasks = new Scanner(System.in);
        String userWish = "";
        String input1;
        String input2;

        System.out.println("Welcome to your TODO List Manager!");
        while(!userWish.equalsIgnoreCase("Q")) {
            input1 = "";
            input2 = "";
            System.out.println("What would you like to do?");
            System.out.print("(A)dd TODO, (M)ark TODO as done, (L)oad TODOs, (S)ave TODOs, (Q)uit? ");
            userWish = userTasks.nextLine();

            if(userWish.equalsIgnoreCase("A")) {
                System.out.print("What would you like to add? ");
                input1 = userTasks.nextLine();
                if(newList.getSize() > 0) {
                    System.out.print("Where in the list should it be (1-" + (newList.getSize() + 1) + ")? (Enter for end): ");
                    input2 = userTasks.nextLine();
                }
                newList.addItem(input1, input2);
            } else if(userWish.equalsIgnoreCase("M")) {
                if(newList.getSize() > 0) {
                    System.out.print("Which item did you complete (1-" + newList.getSize() + ")? ");
                    input1 = userTasks.nextLine();
                }
                newList.markItemAsDone(input1);
            } else if(userWish.equalsIgnoreCase("L")) {
                System.out.print("File name? ");
                input1 = userTasks.nextLine();
                newList.loadItems(input1);
            } else if(userWish.equalsIgnoreCase("S")) {
                System.out.print("File name? ");
                input1 = userTasks.nextLine();
                newList.saveItems(input1);
            } else if(!userWish.equalsIgnoreCase("Q")) {
                System.out.println("Unknown input: " + userWish);
                newList.printTodos();
            }
        }
    }
}