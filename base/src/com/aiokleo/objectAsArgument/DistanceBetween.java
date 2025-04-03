package com.aiokleo.objectAsArgument;

public class DistanceBetween{
    public static void main(String[] args) {
        Point p1 = new Point(2, 3);
        Point p2 = new Point(4, 5);

        double distance = p1.Distance(p2);
        System.out.println(distance);

    }

}
class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
    }

    public double Distance(Point pointTwo){
        double distance = Math.sqrt(Math.pow(pointTwo.x - this.x, 2) +Math.pow(pointTwo.y - this.y, 2));
        return distance;
    }
}
