import java.lang.Math;

public class Square {
    
    private Point center;
    private double side;

    Square(Point center, double side) throws Exception{
        if(side <= 0) {
            throw new Exception("Side less or equal to 0");
        }

        this.center = center;
        this.side = side;
        
    }

    Square() {
        this.center = new Point(1, 1);
        this.side = 1;
    }

    public double getSide() {
        return side;
    }

    public Point getCenter() {
        return center;
    }

    public void setSide(double side) throws Exception{
        if(side <= 0) {
            throw new Exception("Side less or equal to 0");
        }

        this.side = side;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public Point[] Points() {
        return new Point[] {
            new Point(center.getX() - side/2, center.getY() - side/2),
            new Point(center.getX() + side/2, center.getY() - side/2),
            new Point(center.getX() + side/2, center.getY() + side/2),
            new Point(center.getX() - side/2, center.getY() + side/2)
        };
    }

    public double surface() {
        return side * side;
    }

    public double perimeter() {
        return side * 4;
    }

    public double diagonal() {
        //Distance between 2 opposite corners
        return new Point(center.getX() + side/2, center.getY() + side/2).distanceFromPoint(new Point(center.getX() - side/2, center.getY() - side/2));
    }

}
