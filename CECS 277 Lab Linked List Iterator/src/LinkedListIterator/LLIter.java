package LinkedListIterator;

/**
 * A class for an iterator to a LinkedLIst.
 * Lab: Linked List Iterator
 * @author Nicki Huynh and Vy Nguyen
 * @update 10/30/2019
 */

import java.util.NoSuchElementException;
import java.util.Stack;

public class LLIter implements Iterator {
    LinkedList.Node current;
    LinkedList ll;						//The Linked List that we're servicing
    Stack <LinkedList.Node> trail = new Stack <>();

    /**
     * The constructor might be able to get along with just the ll parameter
     * (that's short for Linked List by the way), but then I would have had
     * to have a getter for the Linked List for the head.  That would have
     * broken the encapsulation of the linked list.  The head that we pass
     * in is just a pointer to the first node (if any) of the linked list,
     * not the pointer to the pointer to the head of the linked list, so changing
     * the passed in head is not going to change the head in the linked list.
     *
     * We could have made LLIter a nested class under LinkedList, but the book
     * chose to do it this way, with an independent class, and I wanted to
     * mimic the book's approach as best as I could.
     * @param ll	The LinkedList that we are iterating over.
     * @param head	A reference to the head of that linked list.
     */
    public LLIter (LinkedList ll, LinkedList.Node head) {
        this.current = head;				//Start the iterator off at the front of the LinkedList.
        this.ll = ll;
    }

    /**
     * Return the node in the collection that we are currently pointed to, and
     * advance the pointer by one.  If the linked list is empty, this will cause
     * an exception.
     * @return	The value of the node that the iterator currently points to.
     */
    @Override
    public String next() {
        if (! this.hasNext()) {
            throw new NoSuchElementException ("Call hasNext first.  No next!");
        } else {
            String result = current.getValue();
            trail.push(current);
            current = current.getNext();
            return result;
        }
    }

    /**
     * Return the previous node in the collection than the current one, and
     * move the pointer back by one.
     * @return	The value of the node previous to the current node.
     */
    @Override
    public String previous() {
        if (! this.hasPrevious()) {
            throw new NoSuchElementException ("Call hasPrevious first.  No previous!");
        } else {
            LinkedList.Node previous = trail.pop();
            this.current = previous;
            return previous.getValue();
        }
    }

    /**
     * Test to see whether there is another node to retrieve.
     * @return	The value of the node that the iterator currently points to.  When
     * 			this is done, the iterator will point to the next node in the collection.
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        if (this.current != null) {
            result = true;
        }
        return result;
    }
    
    /**
     * Test to see whether there is a node previous to the current one in the collection.
     * @return	Flag to show whether there is a node that you can retrieve by using
     * 			the previous() member method.
     */
    @Override
    public boolean hasPrevious() {
        return (trail.size() > 0);
    }
    
    /**
     * Insert a new node at the current location of the iterator.  When this is done,
     * the iterator will still be pointing to the node that it was before.
     * @param	value	The value of the node to insert at this point in the
     * 					LinkedList.
     */
    @Override
    public void insert(String value) {
        LinkedList.Node newNode = new LinkedList.Node(value, null);
        if (this.trail.size() > 0) {	//We are in the middle of the list
            trail.peek().setNext(newNode);
            trail.push(newNode);
            newNode.setNext(this.current);
        } else {
            this.ll.front(value);
            this.trail.push(this.ll.head);
        }
    }

    /**
     * Deletes the node before the current location of the iterator.
     */
    @Override
    public void delete() {
    	// if the stack has something in it
        if (this.trail.size() > 1) {
        	this.trail.pop(); // take out from the stack
            // link what inside the stack with current
            // if it doesn't have next, the current is null
            this.trail.peek().setNext(current); 
        }
        // take out the last of the stack
        else {
        	// set the head equal the current
            this.ll.head = this.current;
            this.trail.pop(); // take out from the stack
        }
    }

}