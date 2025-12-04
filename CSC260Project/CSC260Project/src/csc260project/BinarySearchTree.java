
package csc260project;

/**
 *
 * @author therealrinrin
 */
public class BinarySearchTree {
    
    private class BinaryTreeNode{
        private int value; 
        private BinaryTreeNode leftChild;
        private BinaryTreeNode rightChild;
        private BinaryTreeNode parent;
        
        public BinaryTreeNode(int value, BinaryTreeNode leftChild, BinaryTreeNode rightChild, BinaryTreeNode parent){
            this.value = value; 
            this.leftChild = leftChild; 
            this.rightChild = rightChild; 
            this.parent = parent;
        }  
        
        public int getValue(){
            return value;
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
        
        public void setValue(int value){
            this.value = value;
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
            return "" + value;
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
    void insert(int keyVal){
        BinaryTreeNode newNode = new BinaryTreeNode(keyVal, null, null, null);
        if(isEmpty()){
            root = newNode;
            size++;
            return;
        }else{
            BinaryTreeNode Current = root;
            BinaryTreeNode Parent = Current;
            while(true){               
                Parent = Current;
                if(keyVal == Current.value){
                    System.out.println("Duplicate Found.");
                    return;
                }
                else if(keyVal<Current.value){
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
    BinaryTreeNode find(BinaryTreeNode node, int keyVal){
        if(node==null){
            System.out.println("Searching Failed.");
            return null;
        }
        if(node.value ==keyVal){
            return node; // Found
        }
        if(keyVal < node.value){
            return find(node.leftChild, keyVal);
        }else{
            return find(node.rightChild, keyVal);
        }           
    } 
    
    public int maxDepth(BinaryTreeNode leftNode, BinaryTreeNode rightNode){
        if(node == null){
            
        }
    }
    void inorder(BinaryTreeNode node){
        if(node == null){   
            return;            
        }
        inorder(node.leftChild);
        System.out.println(node.value);
        inorder(node.rightChild);    
    }
    void postorder(BinaryTreeNode node){
        if(node==null){
            return;
        }
        postorder(node.leftChild);
        postorder(node.rightChild);
        System.out.println(node.value);
        
        
    }
    void preorder(BinaryTreeNode node){
        if(node==null){
            return;
        }
        System.out.println(node.value);
        preorder(node.leftChild);
        preorder(node.rightChild);
    } 
    
    BinaryTreeNode findMin(BinaryTreeNode node){
        if(isEmpty()){
            return null;
        }     
        while(node.getLeftChild() != null){
            node = node.getLeftChild();
        }
        return node;
    }
    
    BinaryTreeNode findMax(BinaryTreeNode node){
        if(isEmpty()){
            return null;
        }     
        while(node.getRightChild() != null){
            node = node.getRightChild();
        }
        return node;
    }
}
