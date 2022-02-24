package cecs277LabObserverPattern;

/**
 * For the sake of the weather station, all of the display elements do the
 * same basic thing, but differently,  so we have them all implement this
 * interface.  This is not strictly a part of the Observer pattern.
 * @author	David Brown
 * @date	08/20/2019
 */
public interface DisplayElement {
	public void display();
}
