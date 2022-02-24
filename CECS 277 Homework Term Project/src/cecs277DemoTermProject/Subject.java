package cecs277DemoTermProject;
/**
 * A Interface for Subject, which is the one being observed and notifies for any changes.
 * @author Vy Nguyen and Nicki Huynh
 * @update 12/09/2019
 */
public interface Subject {
    /**
     * Adds a new observer to the list of subscribers.
     * @param observer      The new observer.
     * @return              True if observer was added,
     *                      false if they already exist.
     */
    public boolean registerObserver (Observer observer);

    /**
     * Removes an existing observer, unsubscribe them.
     * @param observer      The existing observer to remove.
     * @return              True if found and removed, false
     *                          if they do not exist in list.
     */
    public boolean removeObserver (Observer observer);
    
	/**
	 * Pass along the new values to all of the registered observers.
	 */
	public void notifyObservers();
}
