/**
 * A Interface for Observer, which will grab updated info from Subject.
 * Homework: Observer Pattern
 * @author Nicki Huynh and Vy Nguyen
 * @update 12/02/2019
 */

public interface Observer {
    /**
     * The method that subject will call on to update the stock market changes to the subscribers.
     * @param updateStock     The current stock changes.
     */
    public void update (Subject updateStock);
}
