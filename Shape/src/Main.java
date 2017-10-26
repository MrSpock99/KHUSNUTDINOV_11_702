public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(1,2);
        Shape ellipse = new Ellipse(2,4);
        Shape rect = new Rectangle(5,7, 2,6);
        Shape square = new Square(5,6,4,4);

        Shape[] shapes = {circle,ellipse,rect,square};

        for (Shape shape : shapes){
            System.out.println(shape.getS());
            System.out.println(shape.getP());
            System.out.println();
        }
    }
}
