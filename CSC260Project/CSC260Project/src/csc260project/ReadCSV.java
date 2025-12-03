/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csc260project;
// HELLO EVERYONE 
/**
 *
 * @author darrin
 */
import java.io.*;
import java.util.ArrayList;
public class ReadCSV {
    public static void main(String[] args){
        
        //CSV Stands for comma seperated values
        String file = "CSC260Project/CSC260Project/src/csc260project/election_data.csv";
        BufferedReader reader = null;
        String line = "";
        try{
            reader = new BufferedReader(new FileReader(file));
            ArrayList<String> electionData = new ArrayList<>();          
            while((line=reader.readLine()) != null){
                String[] Edata = line.split(",");
                
                for(String index : Edata){
                    
                    System.out.printf("%-15s", index);  
                }
                System.out.println();
                for(int i = 0; i < Edata.length; i++){
                    electionData.add(Edata[i]);
                }
            }
            System.out.println(electionData.get(4));
            System.out.println(Integer.parseInt(electionData.get(5)));
            System.out.println("Size: " +electionData.size());
            
            LinkedList myList = new LinkedList<>();
            for(int i = 5; i<electionData.size()-1; i+=5){
                int ElectionYear = Integer.parseInt(electionData.get(i));
                int ElectionVotes = Integer.parseInt(electionData.get(i+4));            
                myList.addLast(ElectionYear, electionData.get(i+1), electionData.get(i+2), electionData.get(i+3), ElectionVotes);
            }
            myList.forwardDisplay();
            myList.find("Linda Young");
            
            myList.forwardDisplay();
            myList.addAtState(2016, "Massachusetts", "Republican", "Darrin Phimphisane", 50);
            myList.find("George Allen");
            myList.forwardDisplay();          
            
            QueueApp.byState(myList);
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }               
    }
}
