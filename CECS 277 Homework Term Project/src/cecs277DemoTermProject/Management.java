package cecs277DemoTermProject;
/**
 * Management interface, which acts like an observer interface.
 * @author Vy Nguyen and Nicki Huynh
 * @date 12/09/2019
 */
public interface Management {
    /**
     * The method that subject will call on to update to the subscribers.
     * @param colony     The colony that is being updated.
     */
    public void update(Customer colony);
}
