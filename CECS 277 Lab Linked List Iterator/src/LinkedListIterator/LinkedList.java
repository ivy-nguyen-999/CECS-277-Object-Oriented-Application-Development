package LinkedListIterator;

/**
 * A minimal Linked List implementation.  Note that there is only the forward link in this
 * linked list.  We do not actually need a previous pointer since we can navigate back and
 * forth in the linked list using the iterator.  The iterator pushes the reference on each
 * time that we move forward in the linked list.
 * @author	Dave Brown, Nicki Huynh, Vy Nguyen
 * @date	08/02/2019
 */

//Was not touched, no updates needed
public class LinkedList {
    /**
     * A node within the Linked List.  We will never expose any of our nodes to anyone on
     * outside, but this class has to be public because the LLIter class is NOT a nested
     * class, and it needs to be able to operate on these nodes.  The only real protection
     * that we have there is that the Iterator can only be created from inside of the
     * LinkedList class when it passes in its head.
     * @author	Dave Brown
     * @date	08/02/2019
     */
    static public class Node {
        /** Note that this does not have to be a String object, it could have been anything. */
        private String value;
        /** Pointer to the next node in the singly linked list */
        private Node next;

        public Node (String value, Node next) {
            this.value = value;
            this.next = next;
        }

        /**
         * Returns the value of the node.
         * @return	The value of the node.
         */
        public String getValue() {return this.value;}

        /**
         * Returns the pointer to the next node.
         * @return	Pointer to the next node in the LinkedList.
         */
        public Node getNext() {return this.next;}

        /**
         * Sets the pointer to the next node.
         * @param	next	The new pointer to the next node.
         */
        public void setNext(Node next) {this.next = next;}
    }

    /** Pointer to the start of the LinkedList. */
    Node head;

    public LinkedList() {
        //Signify that the LinkedList is empty.
        head = null;
    }

    /**
     * Add a new node to the end of the Linked List.
     * @param value		The element to append to the end of the linked list.
     */
    public void append (String value) {
        Node newNode = new Node (value, null);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node current = this.head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    /**
     * Insert a new node at the front of the LinkedList.
     * @param	value	The new element to insert into the LinkedList.
     */
    public void front (String value) {
        if (this.head == null) {						//See whether this new element is the first.
            this.append(value);							//The first and the last node are one in the same.
        } else {
            Node newNode = new Node (value, this.head);	//Create the new node, pointing at the old head.
            this.head = newNode;						//The new node is now the head of the linked list.
        }
    }

    /**
     * Construct a new Iterator for the LinkedList.  This iterator has to have access to the LinkedList
     * itself as well as the head because only the LinkedList itself can modify the head of the list.
     * @return	The Iterator, pointing at the start of the LinkedList.
     */
    public Iterator LinkedListIter () {
        Iterator result = new LLIter (this, this.head);
        return result;
    }
}