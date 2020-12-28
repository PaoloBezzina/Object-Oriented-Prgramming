/**
 * node
 */
public class Node {
    boolean leaf;
    Node[] children;

    int x, y;
    boolean value;

    Node() {
        this.children = new Node[4];
        this.leaf = false;

        this.x = 0;
        this.y = 0;
        this.value = false;
    }

    Node(int x, int y, boolean value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean getValue() {
        return this.value;
    }

}
