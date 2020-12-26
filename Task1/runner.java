import java.io.*;
import java.util.Scanner;

/*
True = White
False = Black

NW | NE
-------
SW | SE
*/

public class runner {

    public static void main (String [] args){

        char[][] TXTarr = new char[4][8];
        Node[][] CSVarr = new Node[4][8];

        readTextFile(TXTarr,"object-oriented-programming-assignment/Task1/test.txt");
        print2D(TXTarr);

        readCSVFile(CSVarr,"object-oriented-programming-assignment/Task1/test.csv");
        printNode(CSVarr);
    }

    public static void readCSVFile(Node[][] arr, String fileName){

        try{  
            //setting which file should be read
            FileInputStream file = new FileInputStream(fileName);

            //initialising scanner for file
            Scanner sc = new Scanner(file);

            //checks if there is another line to be read 
            while(sc.hasNextLine()){

                String line = sc.nextLine();

                System.out.println(line);

                String[]tokens = line.split(",");
                int yValue = Integer.parseInt(tokens[0])-1;
                int xValue = Integer.parseInt(tokens[1])-1;
                
                System.out.println(yValue);              
                System.out.println(xValue);
                System.out.println(arr[yValue][xValue].getValue());
                
                arr[yValue][xValue].setX(xValue);
                arr[yValue][xValue].setY(yValue);
                arr[yValue][xValue].setValue(true);

            }  
                sc.close();

        }catch(IOException e){  
            e.printStackTrace();
        }
    }

    public static void readTextFile(char[][] arr, String fileName){

        try{  
            //setting which file should be read
            FileInputStream file = new FileInputStream(fileName);

            //initialising scanner for file
            Scanner sc = new Scanner(file); 

            int lineNum = 0;

            //checks if there is another line to be read 
            while(sc.hasNextLine()){

                String line = sc.nextLine();

                //System.out.println(line);

                arr[lineNum] = line.toCharArray();

                lineNum++;
            }  
                sc.close();

        }catch(IOException e){  
            e.printStackTrace();  
        }
    }

    public static void print2D(char array[][]){

        // Loop through all rows 
        for (int i = 0; i < array.length; i++){

            // Loop through all elements of current row 
            for (int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j]);
            }
            
            System.out.println();
        } 
    }

    public static void printNode(Node array[][]){

        // Loop through all rows 
        for (int i = 0; i < array.length; i++){

            // Loop through all elements of current row 
            for (int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j].getValue());
            }
            
            System.out.println();
        } 
    }

}
