public class Boundary {

    int minX, minY, maxX, maxY;

    public Boundary(int minX, int minY, int maxX, int maxY) {
        
        super();
        
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public int getminX() {
        return minX;
    }

    public int getminY() {
        return minY;
    }

    public int getxMax() {
        return maxX;
    }

    public int getmaxY() {
        return maxY;
    }

    public boolean inRange(int x, int y) {
        boolean inRange =   x >= this.getminX() && 
                            x <= this.getxMax() && 
                            y >= this.getminY() && 
                            y <= this.getmaxY();
        return inRange;
    }

}
