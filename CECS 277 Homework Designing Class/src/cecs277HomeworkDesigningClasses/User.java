package cecs277HomeworkDesigningClasses;

/**
A interface for the user of the vending machine, maintenance or customer.
Homework Assignment: Designing Classes
@author Nicki Huynh and Vy Nguyen
@date 10/09/2019
*/

public interface User {
	//Add more products into the vending machine
	void addProduct(String name, int quantity);
	//Remove the coins that are currently in the vending machine
	void removeCoins(); 
}
