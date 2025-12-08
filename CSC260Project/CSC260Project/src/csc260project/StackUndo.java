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
    // to keep track of previous state for undo functionality
    private Object[] stackBefore;
    private int capacity;
    
    private int top = -1;
    
    public StackUndo(int capacity){
        this.capacity = capacity;
        stack = new Object[capacity];
        stackBefore = new Object[capacity];

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
            stack[top] = String.format("Year: %-2d | State: %-15s | Party: %-10s | Candidate: %-20s | Votes: %-15d%n", 
            year, state, party, candidate, votes);
            if(top > 0){
                stackBefore[top] = stack[top -1];
            }
            //size++;
        }
        
    }
    public g pop(){
        if(isEmpty()){
            System.out.println("Stack is underflow");
            return null;
        } else if(top == 0){
            System.out.println("No more undos available");
            return null;
        } 
        stackBefore = stack;
        g temp = (g) stack[top];
        top = top - 1;
        //size--;
        return temp;

    }

    public void display(){
        if(isEmpty()){
            System.out.println("Stack is empty");
        } else {
            System.out.println("\nDisplaying stack contents:");
            for(int k = 0; k <= top; k++){
                if(stack[k] == null){
                    System.out.println("");
                } else {
                    System.out.println(stack[k]);
                }
            }
        }
    }
    public void undo(){
        if(isEmpty()){
            System.out.println("Stack is empty, cannot undo");
        } else {
            System.out.println("\nUndoing last action... \n");
            stack = stackBefore;
        }
        
    }
}

