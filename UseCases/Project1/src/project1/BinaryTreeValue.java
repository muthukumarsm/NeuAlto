package project1;

import java.util.Scanner;

public class BinaryTreeValue {
    
    int  currentDepth,leftChildValue,rightChildValue,parentDepth,parentValue,currentValue;
    Scanner scan;
    BinaryTreeValue objParent,objChild;    
    
    
    public BinaryTreeValue() {
        super();
        leftChildValue = -1;
    }
    
   
    public void mapUserInput(int currentDepth,int currentValue) {
        this.currentDepth = currentDepth;
        this.currentValue= currentValue;
                
    }
    
    public int getLeftChildValue() {

        return this.leftChildValue;
        
    }
    
    public int getCurrentValue() {
        return this.currentValue;
    }
    
    public void setLeftChildValue(int leftChildValue) {
        this.leftChildValue = leftChildValue;
        
    }
    
    public void setRightChildValue(int rightChildValue) {
        this.rightChildValue = rightChildValue;
    }
    
    public void setParentValues(int parentDepth,int parentValue) {
        this.parentDepth = parentDepth;
        this.parentValue = parentValue;
    }
    
    public int getParentDepth() {
        return this.parentDepth;
    }
            
    public int getParentValue() {
        return this.parentValue;
    }
    
    public void setParent(BinaryTreeValue objParent) {
        this.objParent = objParent;
    }
    
    public void setChild(BinaryTreeValue objChlid) {
        this.objChild = objChlid;
        
    }
    
}
            
            
