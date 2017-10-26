public class Rectangle extends Shape{
    protected double width = 0;
    protected double length = 0;

    Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public double getS() {
        return width * length;
    }

    @Override
    public double getP() {
        return 2 * width + 2 * length;
    }
}
