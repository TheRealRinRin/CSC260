
package csc260project;

/**
 *
 * @author therealrinrin
 */
public class BinarySearchTree {
    
    private class BinaryTreeNode{
        private BinaryTreeNode leftChild;
        private BinaryTreeNode rightChild;
        private BinaryTreeNode parent;
        private int year;
        private String state;
        private String party;
        private String candidate;
        private int votes;
        
        public BinaryTreeNode(int year, String state, String party, String candidate, int votes, BinaryTreeNode leftChild, BinaryTreeNode rightChild, BinaryTreeNode parent){
            this.year = year; 
            this.state  = state;
            this.party = party;
            this.candidate = candidate;
            this.votes = votes;
            this.leftChild = leftChild; 
            this.rightChild = rightChild; 
            this.parent = parent;
        }  
        
        public int getYear(){
            return year;
        }
        public String getState(){
            return state;
        }
        public String getParty(){
            return party;
        }
        public String getCandidate(){
            return candidate;
        }
        public int getVotes(){
            return votes;
        }
        public BinaryTreeNode getLeftChild(){
            return leftChild;
        }
        public BinaryTreeNode getRightChild(){
            return rightChild;
        }
        public BinaryTreeNode getParent(){
            return parent;
        }
        
        public void setYear(int year){
            this.year = year;
        }
        public void setState(String state){
            this.state = state;
        }
        public void setParty(String party){
            this.party = party;
        }
        public void setCandidate(String candidate){
            this.candidate = candidate;
        }
        public void setVotes(int votes){
            this.votes = votes;
        }
        public void setLeftChild(BinaryTreeNode leftChild){
            this.leftChild = leftChild;
        }
        public void setRightChild(BinaryTreeNode rightChild){
            this.rightChild = rightChild;
        }
        public void setParent(BinaryTreeNode parent){
            this.parent = parent;
        }   
        
        @Override
        public String toString(){
            return System.out.printf("Year: %-2d | State: %-15s | Party: %-10s | Candidate: %-20s | Votes: %-15d%n", year, state, party, candidate, votes).toString();
        }
    }
    private BinaryTreeNode root;
    private int size;
    BinarySearchTree(){
        
    }
    BinaryTreeNode getRoot(){
        return root;
    }
    int getSize(){
        return size;
    }
    boolean isEmpty(){
        return size==0;
    }
    void insert(int year, String state, String party, String candidate, int votes){
        BinaryTreeNode newNode = new BinaryTreeNode(year, state, party, candidate, votes, null, null, null);
        if(isEmpty()){
            root = newNode;
            size++;
            return;
        }else{
            BinaryTreeNode Current = root;
            BinaryTreeNode Parent = Current;
            while(true){               
                Parent = Current;
                if(votes == Current.votes){
                    System.out.println("Duplicate Found.");
                    return;
                }
                else if(votes < Current.votes){
                    Current = Current.leftChild;
                    if(Current == null){
                        Parent.leftChild = newNode;
                        newNode.parent = Parent;
                        break;
                    }
                }
                else{
                    Current = Current.rightChild;
                    if(Current==null){
                        Parent.rightChild = newNode;
                        newNode.parent = Parent;
                        break;
                    }
                }    
            }
            size++;
        }          
    }  
    BinaryTreeNode find(BinaryTreeNode node, int votes){
        if(node==null){
            System.out.println("Searching Failed.");
            return null;
        }
        if(node.votes == votes){
            return node; // Found
        }
        if(votes < node.votes){
            return find(node.leftChild, votes);
        }else{
            return find(node.rightChild, votes);
        }           
    } 
    
    public int maxDepth(BinaryTreeNode node){
        if(node == null){
            return 0;
        }
        int leftDepth = maxDepth(node.leftChild);
        int rightDepth = maxDepth(node.rightChild);
        return Math.max(leftDepth, rightDepth) + 1;
    }
    void inorder(BinaryTreeNode node){
        if(node == null){   
            return;            
        }
        inorder(node.leftChild);
        System.out.println(node.votes);
        inorder(node.rightChild);    
    }
    void postorder(BinaryTreeNode node){
        if(node==null){
            return;
        }
        postorder(node.leftChild);
        postorder(node.rightChild);
        System.out.println(node.votes);
        
        
    }
    void preorder(BinaryTreeNode node){
        if(node==null){
            return;
        }
        System.out.println(node.votes);
        preorder(node.leftChild);
        preorder(node.rightChild);
    } 
    BinarySearchTree findNode(int votes){
        System.out.println();
        System.out.println("Finding Candidate With " + votes + " Votes...");
        BinaryTreeNode foundNode = find(root, votes);
        if(foundNode != null){
            System.out.println("Candidate Found: "+ foundNode.toString());
        }
        return this;
    }
    BinaryTreeNode findMinVotes(BinaryTreeNode node){
        System.out.println();
        System.out.println("Finding Candidate With Least Votes...");
        if(isEmpty()){
            return null;
        }     
        while(node.getLeftChild() != null){
            node = node.getLeftChild();
        }
        return node;
    }
    
    BinaryTreeNode findMaxVotes(BinaryTreeNode node){
        System.out.println();
        System.out.println("Finding Candidate With Most Votes...");
        if(isEmpty()){
            return null;
        }     
        while(node.getRightChild() != null){
            node = node.getRightChild();
        }
        return node;
    }
    
}
