/**
 * A class that contains methods for geometric objects.
 * Homework Assignment: IPI
 * @author Nicki Huynh and Vy Nguyen
 * @date 09/25/2019
 */

public abstract class GeometricObject implements Comparable<GeometricObject> {

    /**
     * Returns the area of the geometric object.
     */
    abstract double getArea();

    /**
     * Returns the perimeter of the geometric object.
     */
    abstract double getPerimeter();

    /**
     * Returns a String version of its area and perimeter.
     */
    public abstract String toString();

    /**
     * Compare one instance of GeometricObject to another instance
     *  of GeometricObject by their Area.
     * @param Other the second GeometricObject in the comparison.
     * @return 	< 1 if this GeometricObject < the other.
     * 			= 0 if they are equal.
     *			> 1 if this > the other.
     */
    @Override
    public int compareTo(GeometricObject Other) {
        if (this.getArea() > Other.getArea()) {
            return 1;
        } //Returns 1 if first object is bigger than second.
        else if (this.getArea() < Other.getArea()) {
            return -1;
        } //Return -1 if first object is smaller than second.
        return 0;
    }

    /**
     * Returns the object that is the larger of the two.
     * @param ObjOne the first GeometricObject in the comparison.
     * @param ObjTwo the second GeometricObject in the comparison.
     * @return one of them if they are equal.
     */
    public static GeometricObject max(GeometricObject ObjOne, GeometricObject ObjTwo) {
        //Use the result from Comparable to compare.
        int geometricComp = ObjOne.compareTo(ObjTwo);
        return (geometricComp == -1? ObjTwo : ObjOne);
    }
}

