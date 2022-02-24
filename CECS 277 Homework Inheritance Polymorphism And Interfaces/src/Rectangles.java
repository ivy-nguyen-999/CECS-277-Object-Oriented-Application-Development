/**
 * A class that creates a rectangle, containing a width, height and point.
 * Homework Assignment: IPI
 * @author Nicki Huynh and Vy Nguyen
 * @date 09/25/2019
 */

public class Rectangles extends GeometricObject {
    //Instance variables.
    private double mWidth;
    private double mLength;
    private Point mUpperPoint;

    /**
     * Constructor initializes mWidth and mLength.
     * @param width horizontal side of the rectangle.
     * @param length vertical side of the rectangle.
     * @param upper the coordinates of the upper left corner of rectangle.
     */
    public Rectangles(double width, double length, Point upper) {
        if (width <= 0 || length <= 0) {
            throw new IllegalArgumentException("Invalid Input");
        }
        else {
            mWidth = width;
            mLength = length;
            mUpperPoint = upper;
        }
    }

    /**
     * Returns the area of the rectangle.
     */
    public double getArea() {
        return mWidth * mLength;
    }

    /**
     * Returns the perimeter of the rectangle.
     */
    public double getPerimeter() {
        return (mWidth * 2) + (mLength * 2);
    }

    /**
     * Returns the String version of the rectangle.
     */
    public String toString() {
        String temp = "Rectangle: Upper left corner at: " + mUpperPoint.toString()
                + " Width: " + mWidth + " Length: " + mLength + " Area: "
                + getArea() + " Perimeter: " + getPerimeter();
        return temp;
    }
}