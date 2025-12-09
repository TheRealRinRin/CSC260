/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package csc260project;

/**
 *
 * @author darrin phimphisane, loens paul, hlib zhukov
 */
public class CSC260Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList myList = new LinkedList<>();
        BinarySearchTree bst = new BinarySearchTree();
        StackUndo stack = new StackUndo(1000);
        ReadCSV read = new ReadCSV(myList);
        ReadCSV s = new ReadCSV(stack);
        ReadCSV t = new ReadCSV(bst);

        read.main(args);
        

        myList.forwardDisplay();
        QueueApp.byState(myList);       
        QueueApp.byYear(myList);
        QueueApp.byParty(myList);

        
        stack.display();
        stack.display();
        stack.undo();
        stack.display();

        bst.inorder(bst.getRoot());
    }
    
}
