package csc260project;
// use queue to separate data into different sections
public class QueueApp<g> {
    // processs the items from the list into different batch state, year, party,
    // bst alows to traverse by vote count
    // queue allow by year, state, party


    // Author: Loens M Paul
    /**
     * @param args the command line arguments
     */

    private class Node<g>{
        private g element;
        private Node<g> link;
        
        public Node(g value, Node<g> n){
            this.element = value;
            link = n;
        }
        public void setLink(Node n){
            link = n;
        }
        public Node getLink(){
            return link;
        }
        
        @Override
        public String toString(){
            return element + "";
        }
    }
    
    private int count = 0;
    Node <g> front = null;
    Node <g> rear = null;
    
    public int getSize(){
        return count;
    }
    
    public boolean isEmpty(){
        return count == 0;
    }
    
    public g getFront(){
        return front.element;
    }
    
    public Node<g> read(){
        return front.link;
    }
    
    public g getRear(){
        return rear.element;
    }
    
    // Time complexity O(1)
    public void enQueue(g value){
        Node newNode = new Node(value, null);
        if(isEmpty()){
          front = newNode;
          rear = newNode;          
        } else {
            rear.link = newNode;
            rear = newNode;
        }
        count++;
    }
    // Time complexity O(1)
    public Node<g> DeQueue(){
        if(isEmpty()){
            System.out.print("Queue is underflow");
            return null;
        } 
        Node<g> temp = front;
        front = front.link;
        count --;
        
        if(count == 0) rear = null;
        return temp;
    }   
    // Time complexity O(n)
    public void display(){
        Node <g> Current;
        Current = front;
        
        if(count == 0){
            System.out.println("List is empty");
        } else {
            for(int i = 0; i < count; i++){
                System.out.print(Current.toString() + " ");
                Current = Current.link;
                                
            }
            System.out.println();
        }
    }
    
    public void concatenate(QueueApp Q2){
            
        g current;
        current = (g) Q2.getFront();
        
        Node<g> n = Q2.read();
        
        Node node = new Node(current, n);
        
        int b = Q2.getSize();
        
        for(int i = 0; i < b; i++) {
            enQueue((g) node);
            node = node.link;
        }            
            
    }

    public static void byState(LinkedList<?> list){
        // separate data by state — traverse nodes from head using LinkedList API
        if(list == null || list.isEmpty()) return;
        String currentState;

        currentState = list.ngetState();
        int count = 0;
       
        System.out.println("\n \n Printing by State...");
        if(count == 0){
            System.out.println();
            System.out.println(currentState);
            System.out.println("---------------------------------------------------");
        }

        while(count < list.size()){ 
            
            // printing current cadidate info
                        
            
           if(currentState.equals(list.ngetState())){
               System.out.printf(
                    "Year: %-2d | State: %-15s | Party: %-10s | Candidate: %-20s | Votes: %-15d%n", 
                    list.ngetYear(), list.ngetState(), list.ngetParty(), list.ngetCandidate(), 
                    list.ngetVotes()
                );
          
           } else {
                currentState = list.ngetState();
                System.out.println();
                System.out.println(currentState);
                System.out.println("---------------------------------------------------");
               System.out.printf(
                    "Year: %-2d | State: %-15s | Party: %-10s | Candidate: %-20s | Votes: %-15d%n", 
                    list.ngetYear(), list.ngetState(), 
                    list.ngetParty(), list.ngetCandidate(), list.ngetVotes()
                );
                if(list.ngetState() == null){
                    break;
                }
                //ystem.out.println("Going to next state...");
                //break;
           }
           list.ngetHead();
           count++;
       }
    }

    public static void byYear(LinkedList<?> list){
        // separate data by state — traverse nodes from head using LinkedList API
        if(list == null || list.isEmpty()) return;
        int currentYear;

        
        int count = 0;

        LinkedList<?> nList = list.sortingByYear();
        currentYear= nList.ngetYear();
       
        System.out.println("\n \n Printing by Year...");
        if(count == 0){
            System.out.println();
            System.out.println(currentYear);
            System.out.println("---------------------------------------------------");
        }

        while(count < nList.size()){ 
            
            // printing current cadidate info
                        
            
           if(currentYear == (nList.ngetYear())){
               System.out.printf(
                    "Year: %-2d | State: %-15s | Party: %-10s | Candidate: %-20s | Votes: %-15d%n", 
                    nList.ngetYear(), nList.ngetState(), nList.ngetParty(), nList.ngetCandidate(), 
                    nList.ngetVotes()
                );
          
           } else {
                currentYear = nList.ngetYear();
                System.out.println();
                System.out.println("\n"+currentYear);
                System.out.println("---------------------------------------------------");
                

               System.out.printf(
                    "Year: %-2d | State: %-15s | Party: %-10s | Candidate: %-20s | Votes: %-15d%n", 
                    nList.ngetYear(), nList.ngetState(), 
                    nList.ngetParty(), nList.ngetCandidate(), nList.ngetVotes()
                );

                //ystem.out.println("Going to next state...");
                //break;
           }

           nList.ngetHead();
           count++;
       }

     
    }

   public static void byParty(LinkedList<?> list){
        // separate data by state — traverse nodes from head using LinkedList API
        if(list == null || list.isEmpty()) return;
        String currentParty;

        
        int count = 0;

        LinkedList<?> nList = list.sortedByParty();
        currentParty= nList.ngetParty();
       
        System.out.println("\n \n Printing by Party...");
        if(count == 0){
            System.out.println();
            System.out.println(currentParty);
            System.out.println("---------------------------------------------------");
        }

        while(count < nList.size()){ 
            
            // printing current cadidate info
                        
            
           if(currentParty.equals(nList.ngetParty())){
               System.out.printf(
                    "Year: %-2d | State: %-15s | Party: %-10s | Candidate: %-20s | Votes: %-15d%n", 
                    nList.ngetYear(), nList.ngetState(), nList.ngetParty(), nList.ngetCandidate(), 
                    nList.ngetVotes()
                );
          
           } else {
                currentParty = nList.ngetParty();
                System.out.println();
                System.out.println("\n"+currentParty);
                System.out.println("---------------------------------------------------");
                

               System.out.printf(
                    "Year: %-2d | State: %-15s | Party: %-10s | Candidate: %-20s | Votes: %-15d%n", 
                    nList.ngetYear(), nList.ngetState(), 
                    nList.ngetParty(), nList.ngetCandidate(), nList.ngetVotes()
                );

                //ystem.out.println("Going to next state...");
                //break;
           }

           nList.ngetHead();
           count++;
       }

     
    }

 

}