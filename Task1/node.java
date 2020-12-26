/**
 * node
 */
class Node {
    public int x, y;
    public boolean value;

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


    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public boolean getValue(){

        return this.value;
    }
}