package cecs277DemoFactoryPatternGeometry;

/**
 * A Rectangle that uses a upper left hand corner, angle, width, and height to
 * define itself.  This approach makes it easy to provide the dimensions of the
 * rectangle, but coming up with the 4 vertices is more of a challenge. 
 * @author	David Brown
 * @Date	September 29th, 2019
 */
public class RectanglePointWidthHeight extends RectangleAbstractClass {
	
	/**
	 * The two possible ways to rotate as we go around the rectangle.
	 * @author	David Brown
	 * @date	10/02/2018
	 */
	public enum Rotation {
		CLOCKWISE (- Math.PI/2),
		COUNTERCLOCKWISE (Math.PI/2);
		private Rotation (double deltaAngle) {
			this.deltaAngle = deltaAngle;
		}
		double deltaAngle;
	}
	
	/** Upper left corner of the rectangle */
	private Point upperLeft;
	
	/** Which way the user rotated around the Rectangle in the point order */
	private Rotation rotation;
	
	/** width of the rectangle */
	private double width;
	
	/** height of the rectangle */
	private double height;
	
	/** Angle of rotation for the rectangle */
	private double angle;
	
	/**
	 * Constructor.  Takes the four corners and converts them to a upper left hand corner, 
	 * width and height in such a way that we can reconstruct the four corners again later.
	 * @param	An array of the four corner points.
	 * @throws InvalidShapeException 
	 */
	public RectanglePointWidthHeight (Point [] corners) throws InvalidShapeException {
		super(corners);
		this.width = corners[0].distance(corners[1]);
		if (corners[1].getX() < corners[0].getX()) {
			this.width = - this.width;
		}
		this.height = corners[1].distance(corners[2]);
		if (corners[2].getY() > corners[1].getY()) {
			this.height = - this.height;
		}
		this.upperLeft = new Point (corners [0]);						//Create a copy of the first point passed in.
		//OK, I'm just showing off here.  First we get the first two corners of the rectangle, and 
		//make a vector out of that pair of points.  Then we have the Vector cough up the direction
		//(in Radians).  Piece of cake.
		this.angle = Vector.getVector(corners[0], corners[1]).getDirection();
		//Figure out which way the user rotated around the Rectangle
		//Borrowed this from https://stackoverflow.com/questions/1165647/how-to-determine-if-a-list-of-polygon-points-are-in-clockwise-order
		//based on getting the area under a curve for each side of the polygon.
		double sumArea = 0;
		Point next;
		for (int i = 0; i < corners.length; i++) {
			//Loop around to the first of the four corners if need be
			next = corners [(i + 1) % corners.length]; 	//Get the next point in the list
			sumArea += (next.getX() - corners [i].getX()) * (next.getY() + corners [i].getY());
		} // End of loop around the (hopefully) 4 corners of the rectangle.
		if (sumArea < 0) this.rotation = Rotation.COUNTERCLOCKWISE;
		else this.rotation = Rotation.CLOCKWISE;
	} // End of the REctanglePointWidthHeight constructor
	
	@Override
	public Point[] getCorners() {
		//Start with the upper left and make our way around to the other three
		Point [] corners = new Point [4];
		corners[0] = this.upperLeft;
		double direction = this.angle;
		//Figure out the change in angle based on the direction of the original points as passed in.
		double deltaDirection = this.rotation.deltaAngle;
		/**
		 * We go back and forth between adding a vector that is the width and a vector that is the height long.
		 */
		double [] dims = {Math.abs(this.height), Math.abs(this.width)};
		for (int i = 1; i < 4; i++) {
			//Using the previous point, calculate the next point based on the magnitude and direction.
			corners[i] = new Vector(dims[i % 2], direction).add(corners[i-1]);
			direction += deltaDirection;							//Next corner is another 90 degrees away
		}
		return corners;
	} // End of the getCorners method

	@Override
	public double getWidth() { return this.width; }

	@Override
	public double getHeight() { return this.height;	}

} // End of the RectanglePointWidthHeight class