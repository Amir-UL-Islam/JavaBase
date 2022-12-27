package com.aiokleo.object_as_argument;

public class Point {
    private final int x;
    private final int y;

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
