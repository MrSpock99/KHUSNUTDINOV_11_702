public class Point implements Comparable{
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    private int x;
    private int y;
    private int floor;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        if (y != point.y) return false;
        return floor == point.floor;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + floor;
        return result;
    }

    public Point(int floor, int x, int y) {
        this.x = x;
        this.y = y;
        this.floor = floor;
    }



    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Object o) {
        Point p = (Point)o;
        /*if (this.num == p.num)return 0;
        else if (this.num > p.num)return 1;
        else if (this.num < p.num)return -1;*/
        if (this.getX() == p.getX() && this.getY() == p.getY()){
            return 0;
        }else if (this.getX() <= p.getX() && this.getY() <= p.getY()){
            return -1;
        }else if (this.getX() >= p.getX() && this.getY() >= p.getY()) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public int getFloor() {
        return floor;
    }
}
