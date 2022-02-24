/**
 * A class that creates a triangle, using three points.
 * Homework Assignment: IPI
 * @author Nicki Huynh and Vy Nguyen
 * @date 09/25/2019
 */

import java.lang.Math;

public class Triangles extends GeometricObject{
    // instance variables
    private Point mOne;
    private Point mTwo;
    private Point mThree;

    /**
     * Constructor initializes 3 sides of a triangle.
     * @param one the first given point.
     * @param two the second given point.
     * @param three the third given point.
     */
    public Triangles(Point one, Point two, Point three) {
        mOne = one;
        mTwo = two;
        mThree = three;
    }

    /**
     * Returns the area of the triangle.
     */
    public double getArea() {
        double sideOne = mOne.getDistance(mTwo);
        double sideTwo = mTwo.getDistance(mThree);
        double sideThree = mThree.getDistance(mOne);

        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - sideOne) * (s - sideTwo) * (s - sideThree));
    }

    /**
     * Returns the perimeter of the triangle.
     */
    public double getPerimeter() {
        double sideOne = mOne.getDistance(mTwo);
        double sideTwo = mTwo.getDistance(mThree);
        double sideThree = mThree.getDistance(mOne);

        return sideOne + sideTwo + sideThree;
    }

    /**
     * Returns the String version of the triangle.
     */
    public String toString() {
        String temp = "Triangle: " + mOne.toString() + ", " + mTwo.toString() + ", " + mThree.toString()
                + ", Area: " + getArea() + ", Perimeter: " + getPerimeter();
        return temp;
    }
}