/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package csc260project;

/**
 *
 * @author darrin phimphisane
 */
public class CSC260Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList myList = new LinkedList<>();
        ReadCSV read = new ReadCSV(myList);
        read.main(args);
        myList.forwardDisplay();
        QueueApp.byState(myList);        
        
    }
    
}
