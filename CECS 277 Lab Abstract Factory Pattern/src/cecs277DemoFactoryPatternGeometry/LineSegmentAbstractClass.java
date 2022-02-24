package cecs277DemoFactoryPatternGeometry;

public abstract class LineSegmentAbstractClass extends GeometricShape {

	@Override
	public double getArea() {
		//A line segment, no matter how long, has no area.
		return 0;
	}

	@Override
	//This is a little whimsical, but we're going to assume that 
	//the perimeter is down one "side" of the line segment.
	public double getPerimeter() {
		return this.getPoints()[0].distance(this.getPoints()[1]);
	}

	@Override
	public Point getLocation() {
		return this.getPoints()[0];				//The first point is the location of the line segment
	}

	@Override
	public abstract Point[] getPoints();
	
	@Override
	public String toString () {
		return "Line Segment - from: " + this.getPoints()[0] + " to " + this.getPoints()[1] + " Area: " + this.getArea() + " perimeter: " + this.getPerimeter();
	} // End of the toString method
} // End of the LineSegmentAbstractClass class