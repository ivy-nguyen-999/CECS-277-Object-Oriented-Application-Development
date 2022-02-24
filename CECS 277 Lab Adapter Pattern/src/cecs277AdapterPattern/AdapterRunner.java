package cecs277AdapterPattern;

public class AdapterRunner {

	public static void main(String[] args) {
		
		// declares a variable of type OldRectangle and populates it with 
		// an instance of RectangleAdapter */
		OldRectangle rectangle = new RectangleAdapter(new Point(0,0), new Point(0, 8), new Point(5,0), new Point(5,8));
		
		System.out.println("The area of the rectangle: " + rectangle.getArea());
		System.out.println("The perimeter of the rectangle: " + rectangle.getPerimeter());
		System.out.println("The diagonal of the rectangle: " + rectangle.getDiagonal());
		System.out.println("Four corners of the rectangle:");
		for(Point point : rectangle.getCorners()) {
			System.out.println("	" + point.toString());
		}
		
	}

}
