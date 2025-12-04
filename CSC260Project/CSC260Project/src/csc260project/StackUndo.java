package csc260project;

public class StackUndo <g> {
    // stack to implement undo functionality
    // have an undo method in main that run stack pop
    // Stack will store diferent states of the linked list
    // to run linked list, must go through stack to get to current state
    // when undo is called, pop the stack to get previous state

    //Use an array stack to 


    /**
     * @param args the command line arguments
     */

    private Object[] stack;
    //private int size;
    private int top = -1;
    
    public StackUndo(int capacity){
        stack = new Object[capacity];
    }

    public boolean isEmpty(){
        return top == -1;
    }
    
    public int getSize(){
        return top + 1;
    }
    
    public boolean isFull(){
        return top == stack.length - 1;
    }
    
    public g getTop(){
        return (g) stack[top];
    }
    
    public void push(int year, String state, String party, String candidate, int votes){
        if(isFull()){
            System.out.println("Stack is overflow");
        } else {
            top = top + 1;
            stack[top] = year + "," + state + "," + party + "," + candidate + "," + votes;
        }
        
    }
    public g pop(){
        if(isEmpty()){
            System.out.println("Stack is underflow");
            
        } 
            g temp = (g) stack[top];
            top = top - 1;
            return temp;
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Stack is empty");
        } else {
            for(int k = 0; k <= top + 1; k++){
                System.out.println(stack[k]);
            }
        }
    }
    public void undo(){
        
    }
}

