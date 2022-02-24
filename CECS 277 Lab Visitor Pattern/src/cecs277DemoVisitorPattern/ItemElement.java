package cecs277DemoVisitorPattern;

/**
 * The interface for each item.
 * @author Vy Nguyen, Nicki Huynh
 * @date 12/02/2019
 */
public interface ItemElement {
	/**
	 * Pass the element to the visitor.
	 * @param visitor the given visitor.
	 */
	public void accept (RentalVisitor visitor); 
}