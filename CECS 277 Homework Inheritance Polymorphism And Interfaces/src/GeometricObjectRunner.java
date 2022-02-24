/**
 * A class that tests the geometric interface and classes.
 * Homework Assignment: IPI
 * @author Nicki Huynh and Vy Nguyen
 * @date 09/25/2019
 */

import java.util.Arrays;

public class GeometricObjectRunner {
	
    public static void main(String[] args) {
        //Create an array of geometric object.
        GeometricObject[] shapes = new GeometricObject[4];

        //Create points and different shaped objects, then inserts into array.
        // Initializes a circle and add it into the array
        Point circleCenter1 = new Point(1.0, 1.0);
        Circles circle1 = new Circles(3.0, circleCenter1);
        shapes[0] = circle1;
        // initializes a triangle and add it into the array
        Point trianglePoint1 = new Point(0.0, 0.0);
        Point trianglePoint2 = new Point(1.0, 1.0);
        Point trianglePoint3 = new Point(2.0, 0.0);
        Triangles triangle1 = new Triangles(trianglePoint1, trianglePoint2, trianglePoint3);
        shapes[1] = triangle1;
        // initializes a rectangle and add it into the array
        Point rectangleCorner1 = new Point(-2.0, 2.0);
        Rectangles rectangle1 = new Rectangles(2.0, 3.0, rectangleCorner1);
        shapes[2] = rectangle1;
        // initializes another circle and add it into the array
        Point circleCenter2 = new Point(5.0, 5.0);
        Circles circle2 = new Circles(2.5, circleCenter2);
        shapes[3] = circle2;

        //Display the array of geometric objects.
        System.out.println("Before the sort");
        for(GeometricObject shape : shapes) {
            //Using method toString to print out each shape.
            System.out.println(shape.toString());
        }
        
        //Displays largest shape.
        System.out.print("Largest found was: ");
        GeometricObject largest = shapes[0];
        for (int j = 1; j < shapes.length; j++)
        {
            //Checks which object is the largest.
            if (GeometricObject.max(largest, shapes[j]) == shapes[j]) {
                largest = shapes[j];
            }
        }
        System.out.println(largest + "\n");

        //Sorts the geometric object array.
        Arrays.parallelSort(shapes);

        //Display the array of geometric objects.
        System.out.println("After the sort");
        for(GeometricObject shape : shapes) {
            //Using method toString to print out each shape.
            System.out.println(shape.toString());
        }
        
        //Displays largest shape.
        System.out.print("Largest found was: ");
        largest = shapes[0];
        for (int j = 1; j < shapes.length; j++)
        {
            //Checks which object is the largest.
            if (GeometricObject.max(largest, shapes[j]) == shapes[j]) {
                largest = shapes[j];
            }
        }
        System.out.println(largest + "\n");
    }
}
