import java.util.ArrayList;

public class Lee {
    //private int[][] field;
    private ArrayList<int[][]> field;
    private int distance = 0;
    private int size;
    private boolean check = false;

    public Lee(ArrayList<int[][]> field) {
        this.field = field;
        this.size = field.get(0).length;
    }

    public ArrayList<Point> getPath(Point begin, Point end) {
        field.get(begin.getFloor())[begin.getX()][begin.getY()] = 0;
        while (field.get(end.getFloor())[end.getX()][end.getY()] == -1 && !check){
            check = true;
            for (int k = 0; k < field.size(); k++){
                for (int i = 0; i < size; i++){
                    for (int j = 0; j < size; j++){
                        if (field.get(k)[i][j] == distance){
                            if (canMove(k,i + 1, j)) {
                                move(k,i + 1, j);
                            }

                            if (canMove(k,i, j + 1)) {
                                move(k,i, j + 1);
                            }

                            if (canMove(k,i, j - 1)) {
                                move(k,i, j - 1);
                            }

                            if (canMove(k,i - 1, j)) {
                                move(k,i - 1, j);
                            }

                            if (k - 1 > 0 && canMove(k - 1,i, j)) {
                                move(k - 1,i, j);
                            }

                            if (k + 1 < field.size() && canMove(k + 1,i, j)) {
                                move(k + 1,i, j);
                            }

                        }
                    }
                }
            }
            distance++;
        }


        ArrayList<Point> res = new ArrayList<>();
        Point p = new Point(end.getFloor(),end.getX(),end.getY());
        res.add(p);
        while (distance > 0){
            distance--;
            p = findPath(end.getFloor(),end.getX(),end.getY());
            if (p != null) {
                end.setX(p.getX());
                end.setY(p.getY());
                end.setFloor(p.getFloor());
                res.add(p);
            }
        }
        System.out.println(res.toString());
        return res;
    }

    private Point findPath(int floor, int x, int y) {
        if (canMoveBack(floor,x + 1, y)) {
            return new Point(floor,x + 1, y);
        }

        if (canMoveBack(floor,x, y + 1)) {
            return new Point(floor,x, y + 1);
        }

        if (canMoveBack(floor,x, y - 1)) {
            return new Point(floor,x, y - 1);
        }

        if (canMoveBack(floor,x - 1, y)) {
            return new Point(floor,x - 1, y);
        }

        if (floor - 1 >= 0 && canMoveBack(floor - 1,x, y)) {
            return new Point(floor - 1,x, y);
        }

        return new Point(floor + 1,x,y);
    }

    private boolean canMove(int floor, int x, int y) {
        try {
            if (field.get(floor)[x][y] == -1) {
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException ignored){}
        return false;
    }

    private boolean canMoveBack(int floor, int x, int y){
        try {
            if (field.get(floor)[x][y] == distance){
                return true;
            }
        }catch (ArrayIndexOutOfBoundsException ignored){}
        return false;
    }

    private void move(int floor,int x, int y) {
        field.get(floor)[x][y] = distance + 1;
        check = false;

    }
}
