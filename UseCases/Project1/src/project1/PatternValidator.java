package project1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class PatternValidator {
    
    Stack primaryStack;
    Stack comparisonStack;
    String userInput;
    boolean patternMatching;
    public PatternValidator(String userInput) {
        super();
        primaryStack = new Stack();
        comparisonStack = new Stack();
        this.userInput = userInput;
        patternMatching = false;
    }
    
    private void populatePrimaryStack() {
        char[] inputArray = userInput.toCharArray();
        int arrayIndex = 0;
        
        for (arrayIndex = 0;arrayIndex < inputArray.length;arrayIndex++) {
            primaryStack.push("" + inputArray[arrayIndex]);
        }
    }
    
    private boolean compareStacks() {
                
        while (!primaryStack.isEmpty()) {
            
            if (comparisonStack.isEmpty()) {
                comparisonStack.push(primaryStack.pop());
            }
            String primaryToCompare = null;
            String comparisonStackTopItem = null;
            if (!primaryStack.isEmpty()) {
                primaryToCompare = (String) primaryStack.peek();
            }
            if (primaryToCompare != null)      {
                 if (comparisonStack.peek() != null) {
                    comparisonStackTopItem = (String)comparisonStack.peek();
                    
                    if ((primaryToCompare.equals("{") && comparisonStackTopItem.equals("}"))  ||
                        (primaryToCompare.equals("(") && comparisonStackTopItem.equals(")")) ||
                        (primaryToCompare.equals("[") && comparisonStackTopItem.equals("]"))) {
                    
                            primaryStack.pop();
                            comparisonStack.pop();
                    }  else {
                        comparisonStack.push(primaryStack.pop());
                    }
                }
            }
        }
        if (primaryStack.size() == 0  && comparisonStack.size()== 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public static void main (String args[]) {
        System.out.println("Enter the regular expression -> ");
        Scanner scan = new Scanner(System.in);
        String userInput = scan.nextLine();
        PatternValidator pv = new PatternValidator(userInput);
        pv.populatePrimaryStack();
        boolean ValidExpression = pv.compareStacks();
        System.out.println("Expression valid ->" + ValidExpression);
        
    }
}
