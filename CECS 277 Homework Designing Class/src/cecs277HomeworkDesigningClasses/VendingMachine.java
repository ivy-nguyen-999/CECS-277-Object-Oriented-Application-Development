package cecs277HomeworkDesigningClasses;

/**
A class with the functionality of what a vending machine can do.
Homework Assignment: Designing Classes
@author Nicki Huynh and Vy Nguyen
@date 10/09/2019
*/

public class VendingMachine extends objectsInVendingMachine implements User {

   //Array of products.
   Product[] products = {Product.DIETPEPSI, Product.WATER, Product.MARSBAR,
		   Product.MMS, Product.POPCORN};
   //Array of coins.
   Coin[] coins = {Coin.PENNY, Coin.NICKEL, Coin.DIME, Coin.QUARTER, 
		   Coin.HALFDOLLAR, Coin.DOLLAR};

   /**
    * Prints array of products in format.
    */
   public void showProducts() {
       for (Product product : products) {
           System.out.println(product.getName() + " Value: " + product.getValue()
           + " Quantity: " + product.getQuantity());
       } //Loops through products to print.
   } // prints out all the products

   /**
    * Prints array of coins in format.
    */
   public void showCoins() {
       for (Coin coin : coins) {
           System.out.println(coin.getName() + " Value: " + coin.getValue()
                   + " Quantity: " + coin.getQuantity());
       } //Loops through coins to print.
   } // prints out all the coins

   /**
    * A method that allows a user to buy a product.
    * @param name A string name of the product the user it trying to buy.
    * @param amount A double amount of how much money is in the machine.
    */
   public void buy(String name, double amount) {
       for (int i = 0; i < products.length; i++) {
           if (name.equalsIgnoreCase(products[i].getName()) 
        	&& amount < products[i].getValue() && products[i].getQuantity() != 0) {
               System.out.println("You need to insert more money to purchase"
               		+ " this product.");
           } //If the amount is less than the price of product.

           else if (name.equalsIgnoreCase(products[i].getName()) 
        	&& amount >= products[i].getValue() && products[i].getQuantity() != 0) {
               System.out.println("Purchasing a: " + products[i].getName() 
            		   + " Value: " + products[i].getValue()
                       + " Quantity: " + products[i].getQuantity());
               System.out.println("Vending a: " + products[i].getName() 
            		   + " Value: " + products[i].getValue()
            		   + " Quantity: " + products[i].getQuantity());

               for (int k = 0; k < coins.length; k++) {
                   if (coins[k].getQuantity() != 0) {
                       System.out.println("Putting a: " + coins[k].getName() 
                    		   + " into the till");
                   } //If the coin quantity is not equal to 0.
               } //Loops through the coins.

               showCoins();
               products[i].setQuantity(-1);
               removeCoins();
           } //If the amount is more or the same as the price of product

           else if (products[i].getQuantity() == 0 
        		   && products[i].getName().equalsIgnoreCase(name)) {
               System.out.print("Sorry, we are fresh out of " );
               System.out.println(products[i].getName() + " Value: " 
            		   + products[i].getValue() + " Quantity: " 
            		   + products[i].getQuantity());
           } //If the product has 0 as a quantity
       }
   }

   /**
    * A method that adds a coin into the machine.
    * @param name A string of the type of coin being inserted.
    */
   public void insertCoin(String name) {
       for (int i = 0; i < coins.length; i++) {
           if (name.equalsIgnoreCase(coins[i].getName())) {
               coins[i].setQuantity(1);
               setAmount(coins[i].getValue());
           } //If the name matches the coin name.
       } //Loops through the coins.
   }

   /**
    * A method that adds a product into the vending machine.
    */
   @Override
   public void addProduct(String name, int quantity) {
       for (int i = 0; i < products.length; i++) {
           if (products[i].getName().equalsIgnoreCase(name)) {
               products[i].setQuantity(quantity);
           } //If the name matches the product's name.
       } //Loops through the products.
   }

   /**
    * A method that removes all coins in the machine.
    */
   @Override
   public void removeCoins() {
       for (int i = 0; i < coins.length; i++) {
           coins[i].setQuantity(-coins[i].getQuantity());
       } //Loops through the coins.
       setAmount(-getAmount());
   }
}
