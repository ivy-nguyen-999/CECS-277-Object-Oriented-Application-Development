/**
 * A class that creates a circle, containing a radius and a center point.
 * Homework Assignment: IPI
 * @author Nicki Huynh and Vy Nguyen
 * @date 09/25/2019
 */

import java.lang.Math;

public class Circles extends GeometricObject {
    //Instance variables.
    private double mRadius;
    private Point mCenter;

    /**
     * Constructor initializes mRadius.
     * @param radius the given radius of the circle.
     * @param center the coordinates of the circle's center.
     */
    public Circles(double radius, Point center) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Invalid Input");
        } //If radius' input is 0, it's considered invalid input.
        else {
            mRadius = radius;
            mCenter = center;
        } //If radius' input is > 0, radius and center is inputted.
    }

    /**
     * Returns the Area of the circle.
     */
    public double getArea() {
        return (mRadius * mRadius * Math.PI);
    }

    /**
     * Returns the Perimeter of the circle.
     */
    public double getPerimeter() {
        return (mRadius * 2 * Math.PI);
    }

    /**
     * Returns a String version of the circle.
     */
    public String toString() {
        String temp = "Circle: Center at: " + mCenter.toString() + " Radius: "
                + mRadius + " Area: " + getArea() + " Perimeter: "
                + getPerimeter();
        return temp;
    }
}
