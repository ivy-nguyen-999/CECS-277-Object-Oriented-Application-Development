package cecs277LabDecoratorDesignPattern;

public abstract class ShapeDecorator extends GeometricObject {
	/** This is the decorated object that we're augmenting through composition. */
	private GeometricObject decoratedShape;
	
	public GeometricObject getDecoratedShape () { return this.decoratedShape; }

	/**
	 * Note that this constructor will never get used directly since this is an abstract class.
	 * This constructor only comes into play when one of the subtypes of this abstract class 
	 * (which is concrete) calls this constructor using super(decoratedShape).
	 * @param	decoratedShape	Either a concrete GeometricObject, or a decorator that
	 * 							decorates a decorator or a concrete GeometricObject.
	 * 							The constructor for each ShapeDecorator category demands that
	 * 							the caller provide both the thing they are decorating, along with 
	 * 							what they are decorating it with. So there is no way to get a
	 * 							chain of just decorations.
	 */
	public ShapeDecorator (GeometricObject decoratedShape) {
		//Stash the decoratedShape that we're going to decorate.
		this.decoratedShape = decoratedShape;
	}
	
	public ShapeDecorator () {
		throw new IllegalArgumentException ("Must supply something to decorate!");
	}
}
