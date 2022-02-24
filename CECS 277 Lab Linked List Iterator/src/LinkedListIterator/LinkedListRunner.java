package LinkedListIterator;

public class LinkedListRunner {

	/**
	 * Write out all of the elements in the linked list that the iterator points to.
	 * @param	The iterator that we are demonstrating.
	 */
	public static void displayLL (Iterator iter) {
		//First write them out in the forward direction
		System.out.println("Listing in the forward direction.");
		while (iter.hasNext()) {
			System.out.println("Next value: " + iter.next());
		}
		//Now write them out in the reverse direction
		System.out.println("And now in reverse.");
		while (iter.hasPrevious()) {
			System.out.println("Previous value: " + iter.previous());
		}
	}
	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		//Put a short sentence into the linked list, one word at a time.  Since the append 
		//function always adds to the end, we will get the words in the right order.
		ll.append("Harry");
		ll.append("loves");
		ll.append("Sally");
		ll.append("very");
		ll.append("much.");
		//Get a brand new iterator that points to the start of the linked list.
		Iterator iter = ll.LinkedListIter();
		System.out.println("Right after appending some words.");
		displayLL (iter);							//Show the elements in the linked list.
		iter.insert("I");							//Insert an element at the front of the list
		iter.insert("think");						//Do that again.
		// Build a new iterator, hence start in at the front.
		iter = ll.LinkedListIter();
		System.out.println("After two iterator inserts: ");
		displayLL (iter);
		iter = ll.LinkedListIter();
		iter.next();
		iter.next(); // make the iterator point to the second element of the stack
		System.out.println("Deleting before the 2nd element");
		while (iter.hasPrevious()) {
			iter.delete();
		}
		System.out.println("What's left: ");
		iter = ll.LinkedListIter();
		displayLL(iter);
		//Deleting the first element in the list is a special case, so we need to test that.
		System.out.println("Deleting the first element");
		iter.next();								//Go past the first element
		iter.delete();
		//Get a fresh iterator that points to the start of the linked list.
		iter = ll.LinkedListIter();
		displayLL(iter);
		//Delete the last element in the list
		while (iter.hasNext()) {
			iter.next();
		}
		iter.delete();
		System.out.println ("After deleting the last element in the linked list.");
		while (iter.hasPrevious()) {
			iter.previous();
		}
		displayLL(iter);
		System.out.println("Completed satisfactorily.");
	}
}