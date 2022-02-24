/**
 * A Class that subscribes the agents and update them of changes.
 * Homework: Observer Pattern
 * @author Nicki Huynh and Vy Nguyen
 * @update 12/02/2019
 */


public class Agent implements Observer {
	/** The name of the agent */
    private String agentName;
    
    /**
     * Default constructor
     */
    public Agent() {
    	this.agentName = "Unknown";
    }
    
    /**
     * Creates an Agent with the given name.
     * @param agentName the name of the agent.
     */
    public Agent(String agentName) {
        this.agentName = agentName;
    }
    
    /**
     * Returns the name of the Agent
     * @return Agent name
     */
    public String toString() {
    	return agentName;
    }
    
    /**
     * The agent gets an update call.
     * @param updateStock the Stock that's been updated via a bid.
     */
    @Override
    public void update(Subject updateStock) {
    	Stock stock = (Stock) updateStock;
    	// The agent goes to that Stock, does a getBid and then print it out
    	String output = "Agent - name: " + agentName + " alerted to " + stock.getBid();
    	System.out.println(output);
    }
}
