package sample;

import java.util.ArrayList;

public class Line {
    private ArrayList<Point> points = new ArrayList<>();

    public void add(Point point){
        points.add(point);
    }
    public void add(int x, int y){
        points.add(new Point(x,y));
    }

    public Point getPoint(int index){
        return points.get(index);
    }

    public int getSize(){
        return points.size();
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public Point getLastPoint(){
        return points.get(points.size() - 1);
    }
}
