package cecs277DemoTermProject;
/**
 * A Interface for Observer, which will grab updated info from Subject.
 * @author Nicki Huynh and Vy Nguyen
 * @update 12/02/2019
 */
public interface Observer {
    /**
     * The method that subject will call on to update to the subscribers.
     * @param update     The change.
     */
    public void update (Subject update);
}
