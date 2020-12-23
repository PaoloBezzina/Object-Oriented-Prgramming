/**
 * node
 */
class Node {
    int x, y;
    boolean value;

	Node(int x, int y, boolean value) {
		this.x = x;
		this.y = y;
		this.value = value;
    }
    
    Node(){
        this.x = 0;
        this.y = 0;
        this.value = false;
}