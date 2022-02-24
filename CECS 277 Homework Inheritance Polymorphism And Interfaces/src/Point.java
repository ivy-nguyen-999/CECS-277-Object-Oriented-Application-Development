/**
 * A class that creates points with x and y coordinates.
 * Homework Assignment: IPI
 * @author Nicki Huynh and Vy Nguyen
 * @date 09/25/2019
 */

import java.lang.Math;

public class Point {
    //Instance variables.
    private double mXCoord;
    private double mYCoord;

    /**
     * Constructor initializes x and y coordinates.
     * @param x the given x coordinate.
     * @param y the given y coordinate.
     */
    public Point(double x, double y) {
        mXCoord = x;
        mYCoord = y;
    }

    //Access methods.
    /**
     * Returns the x coordinate.
     */
    public double getXCoord() {
        return mXCoord;
    }

    /**
     * Returns the y coordinate.
     */
    public double getYCoord() {
        return mYCoord;
    }

    /**
     * Returns the distance between two given points.
     * @param Other the second point.
     */
    public double getDistance(Point Other) {
        //Find the distances between x and between y.
        double xDistance = Other.getXCoord() - mXCoord;
        double yDistance = Other.getYCoord() - mYCoord;
        //Using distance formula to find distance.
        return Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));
    }

    /**
     * Returns a String version of point.
     */
    public String toString() {
        return "Point: X: " + mXCoord + " Y: " + mYCoord;
    }
}
