public class Ellipse extends Shape{
    protected double r1 = 0;
    protected double r2 = 0;

    Ellipse(double s, double p, double r1, double r2) {
        super(s, p);
        this.r1 = r1;
        this.r2 = r2;
    }

    @Override
    public double getS() {
        return Math.PI * r1 * r2;
    }

    @Override
    public double getP() {

    }
}
