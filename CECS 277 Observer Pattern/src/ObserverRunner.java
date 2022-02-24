/**
 * A Class that test the Observer Pattern.
 * Homework: Observer Pattern
 * @author Nicki Huynh and Vy Nguyen
 * @update 12/02/2019
 */

public class ObserverRunner {
    public static void main(String[]  args) {
    	// Create several Stock instances
        Stock ORCL = new Stock(); ORCL.setStock("ORCL", 171.05);
        Stock BA = new Stock(); BA.setStock("BA", 5);
        Stock TRKX = new Stock(); TRKX.setStock("TRKX", 6.812);
        // Create several Agent instances
        Agent Tom = new Agent("Tom Clancey");
        Agent Robert = new Agent("Robert Mitchner");
        Agent Noah = new Agent("Noah ben Shea");
        Agent Richard = new Agent("Richard Rohr");
        // Have the agents subscribe to a few Stocks
        ORCL.registerObserver(Tom);
        ORCL.registerObserver(Robert);
        ORCL.registerObserver(Noah);
        ORCL.registerObserver(Richard);
        BA.registerObserver(Tom);
        BA.registerObserver(Robert);
        TRKX.registerObserver(Noah);
        TRKX.registerObserver(Richard);
        // Place some Bids on the Stocks
        Bid ORCLBid = new Bid(TransactionType.BUY, ORCL, 20);
        Bid BABid = new Bid(TransactionType.SELL, BA, 10);
        Bid TRKXBid = new Bid(TransactionType.BUY, TRKX, 30);
    }
}
