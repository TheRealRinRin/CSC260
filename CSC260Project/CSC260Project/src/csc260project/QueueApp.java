package csc260project;
// use queue to separate data into different sections
public class QueueApp<g> {
    // processs the items from the list into different batch state, year, party,


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
 

}