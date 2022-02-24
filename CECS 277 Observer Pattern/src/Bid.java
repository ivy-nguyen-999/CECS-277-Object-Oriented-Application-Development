/**
 * A Class that sets up a bid from agents when shares are bought or sold.
 * Homework: Observer Pattern
 * @author Nicki Huynh and Vy Nguyen
 * @update 12/02/2019
 */

public class Bid {
	/** transaction type */
	private TransactionType type;
	/** the stock for this transaction */
	private Stock stock;
	/** the number of shares in the trade */
	private int shares;
	
	/**
	 * Defaults constructor
	 */
    public Bid() {
        type = TransactionType.BUY;
        stock = new Stock();
        shares = 0;
    }
    
    /**
     * Creates a bid with transaction type, stock and number of shares
     * @param type the transaction types
     * @param stock the stock for this transaction
     * @param shares the number of shares in the trade
     */
    public Bid(TransactionType type, Stock stock, int shares) {
    	this.type = type;
    	this.stock = stock;
    	this.shares = shares;
    	this.stock.trade(this);
    }
    
    @Override
    public String toString() {
        String bid = "Bid - Symbol: " + stock.getSymbol();
        if (type == TransactionType.BUY) {
            bid += " Buying ";
        }
        else if (type == TransactionType.SELL) {
            bid += " Selling ";
        }
        bid += this.shares + " shares for the amount: $" + (stock.getAmount() * this.shares);
        return bid;
    }
}
