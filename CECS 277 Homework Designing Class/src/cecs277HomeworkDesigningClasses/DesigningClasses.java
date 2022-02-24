package cecs277HomeworkDesigningClasses;

/**
A class that demonstrates the VendingMachine class.
Homework Assignment: Designing Classes
@author Nicki Huynh and Vy Nguyen
@date 10/09/2019
*/

import java.util.*;

public class DesigningClasses {

   public static void main(String[] args) {
	   //Create scanner.
	   Scanner scanner = new Scanner(System.in);
	   //Answer for while loop and to see what user wants to do.
       String answer = ""; 
       //Create a vending machine.
       VendingMachine machine = new VendingMachine(); 
       
       // while the user don't want to quit
       while(!answer.equalsIgnoreCase("q")) {
           System.out.println("S)how Products I)nsert Coin B)uy A)dd Product "
           		+ "R)emove Coins Q)uit");
           answer = scanner.nextLine();

           if (answer.equalsIgnoreCase("s")) {
               System.out.println("Show Products");
               machine.showProducts();
           } //If user wants to see products.

           else if (answer.equalsIgnoreCase("i")) {
               System.out.println("Insert Coin");
               machine.showCoins();
               String type = scanner.nextLine();
               machine.insertCoin(type);
               System.out.println("You have put: " + machine.getAmount()
               		+ " into the machine.");
           } //If user wants to insert coins.

           else if (answer.equalsIgnoreCase("b")) {
               System.out.println("Buy");
               machine.showProducts();
               String item = scanner.nextLine();
               machine.buy(item, machine.getAmount());
           } //If user wants to buy a product.

           else if (answer.equalsIgnoreCase("a")) {
               System.out.println("Add Product");
               machine.showProducts();
               String item = scanner.nextLine();
               System.out.print("How many of " + item + " are you adding? --> ");
               int number = Integer.parseInt(scanner.nextLine());
               machine.addProduct(item, number);
           } //If user wants to add a product.

           else if (answer.equalsIgnoreCase("r")) {
               machine.showCoins();
               machine.removeCoins();
           } //If user wants to remove all coins from machine.
       } //Loops while the answer is not q for quit.

       System.out.println("Quit");
       System.out.println("Completed Satisfactorily");
   }
}

