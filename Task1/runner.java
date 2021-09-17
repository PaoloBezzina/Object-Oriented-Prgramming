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

    public static void main(String args[]) {

        char[][] TXTarr = new char[8][8];
        boolean[][] CSVarr = new boolean[8][8];

        QuadTree tree = new QuadTree(1, new Boundary(0, 0, 8, 8));

        System.out.println("Text File - QuadTree");
        // getTextFile(TXTarr, "Task1/test.txt");
        getTextFile(TXTarr, "test.txt");
        printTextQuad(TXTarr);
        // QuadTree.readTextFile(tree, "Task1/test.txt");
        QuadTree.readTextFile(tree, "test.txt");

        // Traveling the graph
        QuadTree.dfs(tree);

        System.out.println("CSV File - QuadTree");
        // getCSVFile(CSVarr, "Task1/test.csv");
        getCSVFile(CSVarr, "test.csv");
        printCSVQuad(CSVarr);
        // QuadTree.readCSVFile(tree, "Task1/test.csv");
        QuadTree.readCSVFile(tree, "test.csv");

        // Traveling the graph
        QuadTree.dfs(tree);
    }

    public static void getCSVFile(boolean[][] arr, String fileName) {

        try {
            // setting which file should be read
            FileInputStream file = new FileInputStream(fileName);

            // initialising scanner for file
            Scanner sc = new Scanner(file);

            // checks if there is another line to be read
            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                // System.out.println(line);

                String[] tokens = line.split(",");
                int yValue = Integer.parseInt(tokens[0]) - 1;
                int xValue = Integer.parseInt(tokens[1]) - 1;

                arr[yValue][xValue] = true;

            }
            sc.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getTextFile(char[][] arr, String fileName) {

        try {
            // setting which file should be read
            FileInputStream file = new FileInputStream(fileName);

            // initialising scanner for file
            Scanner sc = new Scanner(file);

            int lineNum = 0;

            // checks if there is another line to be read
            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                // System.out.println(line);

                arr[lineNum] = line.toCharArray();

                lineNum++;
            }
            sc.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printTextQuad(char array[][]) {

        // Loop through all rows
        for (int i = 0; i < array.length; i++) {

            // Loop through all elements of current row
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }

            System.out.println();
        }
    }

    public static void printCSVQuad(boolean array[][]) {

        // Loop through all rows
        for (int i = 0; i < array.length; i++) {

            // Loop through all elements of current row
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }

            System.out.println();
        }
    }

}
