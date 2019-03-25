package project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryTreeMax {
    
    Scanner scan;
    int treeDepth;
    ArrayList[] bValue;
    public BinaryTreeMax() {
        super();
        scan = new Scanner(System.in);
        treeDepth = 0;        
    }
    
    private void getUserInput() {
        BinaryTreeValue bObjParent, treeObject;
        System.out.println("Enter the depth of the tree (in Number) : ");
        treeDepth = scan.nextInt();
        int inputIndex,inputCol,inputValue;
        bValue = new ArrayList[treeDepth];
        int treeIndex = 0;
        for (inputIndex = 1; inputIndex <= treeDepth; inputIndex++) {
            bValue[treeIndex] = new ArrayList<BinaryTreeValue>();
            for (inputCol = 1; inputCol <= inputIndex; inputCol ++) {
                System.out.println("Enter the value for Level: " + inputIndex + " and index: " + inputCol);
                inputValue = scan.nextInt();
                treeObject = new BinaryTreeValue();
                treeObject.mapUserInput(inputIndex,inputValue);    

                if (inputIndex > 1) {
                    ArrayList parentObjList = bValue[treeIndex - 1];
                    int parentObjIndex;
                    for (parentObjIndex = 0;parentObjIndex < ((List)parentObjList).size(); parentObjIndex ++) {
                        BinaryTreeValue parentObj =  (BinaryTreeValue)((List)parentObjList).get(parentObjIndex);
                        
                        if (inputCol == 1) {
                            parentObj.setLeftChildValue(inputValue);
                            parentObj.setChild(treeObject);
                            System.out.println("Parent is:" + parentObj.getCurrentValue() +  " " + treeObject.getCurrentValue() + " is set as Left Node ");
                            break;
                        } else if (inputCol == inputIndex && (inputCol - 2 == parentObjIndex || parentObjList.size() == 1)) {
                            System.out.println("Input col " + inputCol + " Input Index " + inputIndex + " parent obj index " + parentObjIndex + " size " + parentObjList.size());
                            parentObj.setRightChildValue(inputValue);
                            parentObj.setChild(treeObject);
                            System.out.println("Parent is: " + parentObj.getCurrentValue() +  "  " + treeObject.getCurrentValue() + " is set as Right Node ");
                            break;
                        } else if (parentObjIndex > 0 && parentObjIndex == inputCol - 1){  
                            
                            parentObj.setLeftChildValue(inputValue);
                            System.out.println("parentObjIndex:" + parentObjIndex + " value: " + parentObj.getLeftChildValue());
                            System.out.println("Parent is: " + parentObj.getCurrentValue() +  "  " + treeObject.getCurrentValue() + " is set as Left Node ");
                            BinaryTreeValue objPrevParent = ((BinaryTreeValue)((List)parentObjList).get(parentObjIndex - 1));
                            objPrevParent.setRightChildValue(inputValue);
                            System.out.println("Parent is: " + objPrevParent.getCurrentValue() +  " " + treeObject.getCurrentValue() + " is set as Right node ");
                            objPrevParent.setChild(treeObject);
                            //break;
                            
                        }
                    }
                }
                bValue[treeIndex].add(treeObject);
            }
            treeIndex += 1;
        }        
    }
    
    public static void main(String args[]) {
        BinaryTreeMax treeMax = new BinaryTreeMax();
        treeMax.getUserInput();        
    }
}
