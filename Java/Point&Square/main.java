public class main {

    public static void main(String args[]) {
        Point p1 = new Point(3, 5);
        Point p2 = new Point(3, 8);

        System.out.println("P1(" + p1.getX() + ", " + p1.getY() + ")");
        System.out.println("P2(" + p2.getX() + ", " + p2.getY() + ")");
        System.out.println("d(p1, p2): " + p1.distanceFromPoint(p2));
    }

}