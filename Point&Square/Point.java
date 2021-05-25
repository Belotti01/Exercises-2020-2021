import java.lang.Math;

;public class Point {
    private double x, y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    Point() {
        x = 0;
        y = 0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setCoords(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceFromPoint(Point point) {
        return Math.sqrt(Math.pow(x - point.x, 2) + Math.pow(y - point.y, 2));
    }
}