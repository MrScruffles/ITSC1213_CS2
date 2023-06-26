class Rectangle {
    private int length;
    private int width;

    public Rectangle() {
        length = 1;
        width = 1;
    }

    public Rectangle(int l, int w) {
        length = l;
        width = w;
    }

    public void draw() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++)
                System.out.print("* ");
            System.out.println();
        }
        System.out.println();
    }

    public int area() {
        return length * width;
    }
}

// 1. Make the class Square inherit from Rectangle
public class Square extends Rectangle {
    // 2. Add a Square no-argument constructor
    public Square() {
        super();
    }

    // 3. Add a Square constructor with 1 argument for a side
    public Square(int side) {
        super(side, side);
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle(3, 5);
        r.draw();

        Square s1 = new Square();
        s1.draw();

        Square s = new Square(3);
        s.draw();

        // Testing the area() method
        System.out.println("Rectangle area: " + r.area());
        System.out.println("Square area (s1): " + s1.area());
        System.out.println("Square area (s): " + s.area());

        // Testing the LongRectangle subclass
        LongRectangle lr = new LongRectangle(4, 2);
        lr.draw();
        System.out.println("LongRectangle area: " + lr.area());
    }
}

// Additional subclass LongRectangle
class LongRectangle extends Rectangle {
    public LongRectangle(int width) {
        super(width * 2, width);
    }

    public LongRectangle(int length, int width) {
        super(length, width);
    }
}
