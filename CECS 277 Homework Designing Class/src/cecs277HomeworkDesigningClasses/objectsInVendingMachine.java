package cecs277HomeworkDesigningClasses;

/**
A class for objects in the vending machine.
Homework Assignment: Designing Classes
@author Nicki Huynh and Vy Nguyen
@date 10/09/2019
*/

public class objectsInVendingMachine {

   private double amount; //Amount of total values from coins.

   /**
    * A getter method for the total amount of values of coins in machine.
    * @return A double amount in the machine.
    */
   public double getAmount() {
       return amount;
   } // gets the value of coins in the machine

   /**
    * A setter method for the amount in the machine.
    * @param amount A double for the amount in the machine.
    */
   public void setAmount(double amount) {
       this.amount += amount;
   } // adds more coins to the machine

   /**
    * Enum class for Products.
    */
   public enum Product {
       /**
        * List of products in vending machine and value.
        */
       DIETPEPSI("Diet Pepsi", 1.25), WATER("Water", 1.0),
       MARSBAR("Mars Bar", 0.65), MMS("M&Ms", 0.65), POPCORN("Popcorn", 1.5);

       private String name; //Name of product.
       private double value; //Value of product.
       private int quantity; //Quantity of product.

       /**
        * Overloaded Constructor of Product.
        * @param name A string for the name of the product.
        * @param value A double for the value of the product.
        */
       Product(String name, double value) {
           this.name = name;
           this.value = value;
           quantity = 0;
       } // sets name and value equal the given input

       /**
        * A getter method for the name of product.
        * @return A string name of the product.
        */
       public String getName() {
           return name;
       } // gets the name of the product

       /**
        * A getter method for the value of product.
        * @return A double value of the product.
        */
       public double getValue() {
           return value;
       } // gets the value of the product

       /**
        * A getter method for the quantity of product.
        * @return An int quantity for the product.
        */
       public int getQuantity() {
           return quantity;
       } // gets the quantity of the product

       /**
        * A setter method for the quantity of product.
        * @param quantity An int for the number of product.
        */
       public void setQuantity(int quantity) {
           this.quantity += quantity;
       } // increments the quantity of the product
   }

   /**
    * Enum class for Coins.
    */
   public enum Coin {
       PENNY("Penny", 0.01), NICKEL("Nickel", 0.05), DIME("Dime", 0.1),
       QUARTER("Quarter", 0.25), HALFDOLLAR("Half Dollar", 0.5),
       DOLLAR("Dollar", 1.0);

       private String name; //Name of coin.
       private double value; //Value of coin.
       private int quantity; //Quantity of coin.

       /**
        * Overloaded constructor for Coin.
        * @param name A string name of the coin.
        * @param value The double value of the coin.
        */
       Coin(String name, double value) {
           this.name = name;
           this.value = value;
           quantity = 0;
       } // assigns value to name, value, and quantity

       /**
        * A getter method for the name of coin.
        * @return A string name of the coin.
        */
       public String getName() {
           return name;
       } // gets the name of coin

       /**
        * A getter method for the value of coin.
        * @return A double value of the coin.
        */
       public double getValue() {
           return value;
       } // gets the value of coin

       /**
        * A getter method for the quantity of the object.
        * @return An int quantity for the object.
        */
       public int getQuantity() {
           return quantity;
       } // gets the quantity of coin

       /**
        * A setter method for the quantity of an object.
        * @param quantity An int for the number of objects.
        */
       public void setQuantity(int quantity) {
           this.quantity += quantity;
       } // increments the quantity of coin
   }
}

