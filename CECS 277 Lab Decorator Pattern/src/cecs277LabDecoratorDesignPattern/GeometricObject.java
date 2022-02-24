package cecs277LabDecoratorDesignPattern;

public abstract class GeometricObject {
	
	@Override
	public abstract String toString ();
	
	/** Draw the Geometric object on the canvas */
	public abstract void draw();
	
	/**
	 * Change the overall area of the object by multiplying its measurements 
	 * by a factor.
	 * @param	percent	The % to change the measurements by.  1.11 would increase it by 11%,
	 * 					.8 would decrease the measurements by 20%
	 */
	public abstract void resize (double percent);
}