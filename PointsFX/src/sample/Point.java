package sample;

public class Point {
    private int x,y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean lesserThanX(Point point) {
        return false;
    }


}
