package project1;

import java.util.Arrays;
import java.util.Scanner;


public class JaggedArrayHandler {
    public JaggedArrayHandler() {
        super();
    }
    
    public static void main(String args[]) {
        
        System.out.println("Enter the number of rows of input data ");
        Scanner rowScan = new Scanner(System.in);
        Scanner colScan = new Scanner(System.in);
        Scanner valueScan = new Scanner(System.in);
        int rowCount = rowScan.nextInt();
        int colCount = 0, totalValues = 0,valueIndex=0;
        int[][] jaggedArray = new int[rowCount][];
        int[] uniDimensionalArray;
        int rowIndex = 0,colIndex = 0,colValue = 0;
        
        for (rowIndex = 0;rowIndex < rowCount;rowIndex++) {
            System.out.println("Enter the number of values for Row: " + (rowIndex + 1));
            colCount = colScan.nextInt();
            jaggedArray[rowIndex] = new int[colCount];
            for (colIndex = 0;colIndex < colCount;colIndex ++) {    
                System.out.println("Enter the value for row: " + (rowIndex + 1) + " and Column: " + (colIndex+1));
                colValue = valueScan.nextInt();
                jaggedArray[rowIndex][colIndex] = colValue;
                
            }
 
        }
        
    System.out.println("Your input was: ");
    for (rowIndex = 0;rowIndex < rowCount;rowIndex++) { 
        colCount = jaggedArray[rowIndex].length;
        totalValues = totalValues + colCount;
        for (colIndex = 0;colIndex < colCount;colIndex++) {
            System.out.print(jaggedArray[rowIndex][colIndex] + "  ");
        }
        
        System.out.println();
    }
    
    uniDimensionalArray = new int[totalValues];
    
    for (rowIndex = 0;rowIndex < rowCount;rowIndex++) { 
        for (colIndex = 0;colIndex < jaggedArray[rowIndex].length;colIndex++) {
    
            uniDimensionalArray[valueIndex] = jaggedArray[rowIndex][colIndex];
            valueIndex +=1;
        }
    }   
    System.out.println("Uni Dimensional array " + Arrays.toString(uniDimensionalArray));      
    }
}
