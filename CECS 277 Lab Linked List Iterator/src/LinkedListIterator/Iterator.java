package LinkedListIterator;

/**
 * A interface for LinkedList, providing a few extra methods to add.
 * Lab: Linked List Iterator
 * @author Nicki Huynh and Vy Nguyen
 * @update 10/30/2019
 */

public interface Iterator {
    /**
     * Return the node in the collection that we are currently pointed to, and
     * advance the pointer by one.  If the linked list is empty, this will cause
     * an exception.
     * @return	The value of the node that the iterator currently points to.
     */
    public String next ();

    /**
     * Return the previous node in the collection than the current one, and
     * move the pointer back by one.
     * @return	The value of the node previous to the current node.
     */
    public String previous ();

    /**
     * Test to see whether there is another node to retrieve.
     * @return	The value of the node that the iterator currently points to.  When
     * 			this is done, the iterator will point to the next node in the collection.
     */
    public boolean hasNext();

    /**
     * Test to see whether there is a node previous to the current one in the collection.
     * @return	Flag to show whether there is a node that you can retrieve by using
     * 			the previous() member method.
     */
    public boolean hasPrevious();

    /**
     * Insert a new node at the current location of the iterator.  When this is done,
     * the iterator will still be pointing to the node that it was before.
     * @param	value	The value of the node to insert at this point in the
     * 					LinkedList.
     */
    public void insert (String value);

    /**
     * Deletes the node before the current location of the iterator.
     */
    public void delete ();
}