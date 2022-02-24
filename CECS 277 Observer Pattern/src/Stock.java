/**
 * A Class that keeps track of the
 *      different stocks.
 * Homework: Observer Pattern
 * @author Nicki Huynh and Vy Nguyen
 * @update 12/02/2019
 */

import java.util.ArrayList;

public class Stock implements Subject {
	/** Our list of stock */
    private ArrayList<Observer> observers;
    /** The symbol of stock */
    private String symbol;
    /** The amount */
    private double amount;
    /** The current bid */
    private Bid bid;
    
	/**
	 * default constructor, create a new ArrayList for observers.
	 */
    public Stock() {
        this.observers = new ArrayList <> ();
        this.symbol = "";
        this.amount = 0;
    }
    
    /**
     * Initializes the symbol and amount of Stock
     * @param symbol the stock symbol
     * @param amount the amount
     */
    public Stock(String symbol, double amount) {
        this.observers = new ArrayList<>();
        this.symbol = symbol.toUpperCase();
        this.amount = amount;
    }
    
	/**
	 * Updates the Stock instance.
	 * @param updateBid update the Bid and store it locally.
	 */
    public void trade(Bid bid) {
        this.bid = bid;
        notifyObservers();
    }
    
	/**
	 * Returns the recent Bid.
	 * @return a copy of the Bid that happened most recently.
	 */
    public Bid getBid() {
        Bid copy = this.bid;
        return copy;
    }
    
    /**
     * Update one or more of the stock.
     * @param symbol The symbol of the stock.
     * @param amount the dollar amount for the whole trade.
     */
    public void setStock(String symbol, double amount) {
    	if (this.symbol.equals("")) {
            this.symbol = symbol.toUpperCase();
    	}
    	if (symbol.toUpperCase().equals(this.symbol)) {
            this.amount = amount;
    	}
    }
    
    /**
     * Changes the amount of the stock
     * @param amount the new amount for stock
     */
    public void setAmount(double amount) {
    	this.amount = amount;
    }
    
    /**
     * Returns the symbol of the stock.
     * @return the symbol
     */
    public String getSymbol() {
    	return this.symbol;
    }
    
    /**
     * Returns the dollar amount for the whole trade.
     * @return the dollar amount.
     */
    public double getAmount() {
    	return this.amount;
    }
    
    @Override
    public boolean registerObserver(Observer observer) {
        if (observers.contains(observer)) {
            return false;
        } // Return false if observer already has that observer
        else {
            observers.add(observer);
            return true;
        } // Return true and add observer otherwise
    }

    @Override
    public boolean removeObserver(Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
            return true;
        } // Return true and remove observer if observer is registered
        else {
            return false;
        } // Return false otherwise
    }

	@Override
	public void notifyObservers() {
		for (Observer next: this.observers) {
			next.update(this);
		}
	}
	
	@Override
	public String toString() {
		return "Symbol: " + this.symbol + ", Cost: " + this.amount;
	}
}
