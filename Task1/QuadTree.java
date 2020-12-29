import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Scanner;

public class QuadTree {

    final int MAX_NODES = 4;
    int level = 0;
    boolean leaf = false;
    List<Node> nodes;
    QuadTree nW = null;
    QuadTree nE = null;
    QuadTree sW = null;
    QuadTree sE = null;
    Boundary bound;

    QuadTree(int level, Boundary bound) {
        this.level = level;
        nodes = new ArrayList<Node>();
        this.bound = bound;
    }

    void insert(int x, int y, boolean value) {
        System.out.println("inserting in: "+ x +", "+ y);
		if (!this.bound.inRange(x, y)) {
			return;
		}

		Node node = new Node(x, y, value);
		if (nodes.size() < MAX_NODES) {
			nodes.add(node);
			return;
		}
		// Exceeded the capacity so split it in FOUR
		if (nW == null) {
			split();
		}

		// Check coordinates belongs to which partition 
		if (this.nW.bound.inRange(x, y)){
			this.nW.insert(x, y, value);
        }else if (this.nE.bound.inRange(x, y)){
			this.nE.insert(x, y, value);
        }else if (this.sW.bound.inRange(x, y)){
			this.sW.insert(x, y, value);
        }else if (this.sE.bound.inRange(x, y)){
			this.sE.insert(x, y, value);
        }else{
            System.out.printf("ERROR : Unhandled partition %d %d ", x, y);
        }
    }

    void split() {
		int xOffset = this.bound.getminX() + (this.bound.getxMax() - this.bound.getminX()) / 2;
		int yOffset = this.bound.getminY() + (this.bound.getmaxY() - this.bound.getminY()) / 2;

		nW = new QuadTree(this.level + 1, new Boundary(this.bound.getminX(), this.bound.getminY(), xOffset,	yOffset));
        nE = new QuadTree(this.level + 1, new Boundary(xOffset,	this.bound.getminY(), this.bound.getminX(), yOffset));
        //error apparently (114) - northEast = new QuadTree(this.level + 1, new Boundry(xOffset, this.boundry.getyMin(), this.boundry.getxMax(), yOffset));

        sW = new QuadTree(this.level + 1, new Boundary(this.bound.getminX(), yOffset, xOffset,this.bound.getmaxY()));
        //error apparently (114) - southWest = new QuadTree(this.level + 1, new Boundry(this.boundry.getxMin(), yOffset, xOffset, this.boundry.getyMax()));
        
		sE = new QuadTree(this.level + 1, new Boundary(xOffset, yOffset,this.bound.getxMax(), this.bound.getmaxY()));
    }

    /* Traveling the Graph using Depth First Search*/
	static void dfs(QuadTree tree) {
		if (tree == null){
			return;
        }

		System.out.printf("\nLevel = %d [X1=%d Y1=%d] \t[X2=%d Y2=%d] ",
				tree.level, tree.bound.getminX(), tree.bound.getminY(),
				tree.bound.getxMax(), tree.bound.getmaxY());

		for (Node node : tree.nodes) {
			System.out.printf(" \n\t  x=%d y=%d", node.x, node.y);
		}
		if (tree.nodes.size() == 0) {
            System.out.printf(" \n\t  Leaf Node.");
            tree.leaf = true;
        }
        
		dfs(tree.nW);
		dfs(tree.nE);
		dfs(tree.sW);
		dfs(tree.sE);

    }
    
    //Parsing files
    public static void readCSVFile(QuadTree tree, String fileName) {

        try {
            // setting which file should be read
            FileInputStream file = new FileInputStream(fileName);

            // initialising scanner for file
            Scanner sc = new Scanner(file);

            // checks if there is another line to be read
            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                System.out.println(line);

                String[] tokens = line.split(",");
                int yValue = Integer.parseInt(tokens[0]) - 1;
                int xValue = Integer.parseInt(tokens[1]) - 1;

                tree.insert(xValue, yValue, true);

            }
            sc.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readTextFile(QuadTree tree, String fileName) {

        char[][] temp;
        String[] lines = new String[8];

        try {
            // setting which file should be read
            FileInputStream file = new FileInputStream(fileName);

            // initialising scanner for file
            Scanner sc = new Scanner(file);

            int lineNum = 0;

            // checks if there is another line to be read
            while(sc.hasNextLine()) {
                lines[lineNum] = sc.nextLine();
                lineNum++;
            }

            temp = new char[lineNum][];
            
            for(int i = 0; i < temp.length; i++){
                temp[i] = lines[i].toCharArray();
            }
            
            for (int yValue = 0; yValue < temp.length; yValue++) {
                for (int xValue = 0; xValue < temp[yValue].length; xValue++) {
                    if(temp[yValue][xValue] == 'T'){
                        System.out.println("\nx: " + xValue + ", y: " + yValue + ", Value: " + temp[yValue][xValue]);
                        tree.insert(xValue, yValue, true);
                        System.out.println("create node");
                    }
                    else if(temp[yValue][xValue] == 'F'){
                        System.out.println("\nx: " + xValue + ", y: " + yValue + ", Value: " + temp[yValue][xValue]);
                        tree.insert(xValue, yValue, false);
                        System.out.println("create node");
                    }
                }
            }
            
            sc.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]) {
        QuadTree tree = new QuadTree(1, new Boundary(0, 0, 4, 4));
        
        readTextFile(tree,"object-oriented-programming-assignment/Task1/test.txt");

        //readCSVFile(tree,"object-oriented-programming-assignment/Task1/test.csv");

		//Traveling the graph
		QuadTree.dfs(tree);
	}
}