package sample;

import java.util.Comparator;

public class YComparator implements Comparator<Point> {
    @Override
    public int compare(Point o1, Point o2) {
        /*if (o1.getY() > o2.getY()){
            return 1;
        }else if (o1.getY() < o2.getY()){
            return -1;
        }else {
            return 0;
        }*/

       if (o1.getX() >= o2.getX() && o1.getY() > o2.getY() && o1.getX() > o2.getX() || o1.getX() == o2.getX() && o1.getY() > o2.getY()){
           return 0;
       }
       return 1;
    }
}
