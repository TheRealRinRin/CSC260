/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csc260project;

/**
 *
 * @author darri
 */
public class LinkedList<E> {
    private static class Node<E>{
        private int year; 
        private String state;
        private String party; 
        private String candidate;
        private int votes; 
        
        private Node next;
        private Node prev;
        
        public Node(int year, String state, String party, String candidate, int votes, Node<E> next, Node<E> prev){
            this.year = year; 
            this.state = state;
            this.party = party;
            this.candidate = candidate;
            this.votes = votes;
            this.next = next;
            this.prev = prev;
        }        
        // Getters        
        public int getYear(){
            return this.year;
        }        
        public String getState(){
            return this.state;
        }        
        public String getParty(){
            return this.party;
        }        
        public String getCandidate(){
            return this.candidate;
        }     
        public int getVotes(){
            return this.votes;
        }        
        public Node<E> getNext(){
            return this.next;
        }        
        public Node<E> getPrev(){
            return this.prev;
        }        
        // Setters
        public void setYear(int y){
            this.year = y;
        }
        public void setState(String s){
            this.state = s;
        }
        public void setParty(String p){
            this.party = p;
        }
        public void setCandidate(String c){
            this.candidate = c;
        }
        public void setVotes(int v){
            this.votes = v;
        }
        public void setNext(Node<E> n){
            this.next = n;
        }
        public void setPrev(Node<E> p){
            this.prev = p;
        }      
    }
    // Instant Variables of the LL 
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;
    public LinkedList(){}
    // Access Methods
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void forwardDisplay(){
        Node<E> Current; 
        Current = head;
        System.out.println("---------------------- Display ----------------------");
        System.out.println();
        for(int i = 0; i < size; i++){
            //System.out.println("Year: "+Current.getYear()+" | State: "+ Current.getState()+" | Party: "+ Current.getParty()+" | Candidate: "+ Current.getCandidate()+" | Votes: "+ Current.getVotes());
            System.out.printf("Year: %-2d | State: %-15s | Party: %-10s | Candidate: %-20s | Votes: %-15d%n", Current.getYear(), Current.getState(), Current.getParty(), Current.getCandidate(), Current.getVotes());
            Current = Current.next;
        }
    }        
    
    // Update Methods
    public void addFirst(int year, String state, String party, String candidate, int vote){
        Node<E> newNode = new Node(year, state, party, candidate, vote, head, null);
        if(size==0){
            head = tail = newNode;
            head.next = head;
            head.prev = head;
        }else{
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode; 
            tail.next = newNode;
            head = newNode;
        }
        size++;
    }
    public void addLast(int year, String state, String party, String candidate, int vote){
        Node<E> newNode = new Node(year, state, party, candidate, vote, null, null);
        if(size==0){
            head = tail = newNode;       
            head.next = head;
            head.prev = head; 
        }else{
            newNode.next = head; 
            newNode.prev = tail; 
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode; 
        }
        size++;
    }
    public void find(String e){
        Node<E> Current;
        Current = head; 
        int counter = 0; 
        while(counter!=size){
            counter++; 
            if(e.equals(Current.getCandidate())){
                System.out.println("Candidate found at index: "+ counter);
            }
            Current = Current.next;
        }
    }
    
    public void addAtState(int year, String state, String party, String candidate, int vote){
        Node<E> newNode = new Node(year, state, party, candidate, vote, head, null);
        Node<E> Current = head;
        if(size==0){
            addFirst(year, state, party, candidate, vote);
            return;
        }else{
            int count = 0;
            while(count < size){
                if(Current.getState().equals(state)){
                    newNode.next = Current.next;
                    newNode.prev = Current;
                    Current.next.prev = newNode;
                    Current.next = newNode;
                    if(Current == tail){
                        tail = newNode;
                    }
                    size++;
                    return;   
                }
                Current = Current.next;
                count++;
            }        
            addLast(year, state, party, candidate, vote);    
        }               
    }
}
