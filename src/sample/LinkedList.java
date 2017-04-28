package sample;

/**
 * @Course: SDEV 350 ~ Java Programming II
 * @Author Name: Adam Flammino
 * @Assignment Name: aflammino_week11
 * @Date: Apr 20, 2017
 * @Subclass LinkedList Description: Linked List implementation
 */
public class LinkedList<E> {
    private static int ctr;
    private Node head;

    /**
     * Constructor
     */
    public LinkedList() {
    }

    /**
     * Method to add data to the LinkedList
     * @param obj
     */
    public void add(Object obj) {
        //If first element, initialize Node
        if (head == null) {
            head = new Node(obj);
        }
        Node mLL_Temp = new Node(obj);
        Node mLL_Curr = head;
        if (mLL_Curr != null) {
            while (mLL_Curr.getNext() != null) { //Move to end of list to add element
                mLL_Curr = mLL_Curr.getNext();
            }
            mLL_Curr.setNext(mLL_Temp); //Set last node next to new node
        }
        incCtr();   //Increment counter
    }

    /**
     * Method to insert data into LinkedList at a specified location
     * @param obj
     * @param index
     */
    public void add(Object obj, int index) {
        Node mLL_Temp = new Node(obj);
        Node mLL_Curr = head;

        if (mLL_Curr != null) {
            //Move to insertion location. Notice counter begins at 1. This compensates for exact position insertion
            for (int i = 1; i < index && mLL_Curr.getNext() != null; i++) {
                mLL_Curr = mLL_Curr.getNext();
            }
        }
        mLL_Temp.setNext(mLL_Curr.getNext()); //Set new node's next-node reference to current node's next-node reference
        mLL_Curr.setNext(mLL_Temp); //Set next-node to new node
        incCtr(); //Increment counter
    }

    /**
     * Method to get counter number
     * @return counter
     */
    private static int getCtr() {
        return ctr;
    }

    /**
     * Method to increment the counter
     */
    private static void incCtr() {
        ctr++;
    }

    /**
     * Method to decrement the counter
     */
    private void decCtr() {
        ctr--;
    }

    /**
     * Returns the elements of the list one by one
     *
     * @param index
     * @return
     */
    public Object get(int index) {
        if (index < 0) {
            return null;
        }
        Node mLL_Curr = null;
        if (head != null) {
            mLL_Curr = head.getNext();
            for (int i = 0; i < index; i++) {
                if (mLL_Curr.getNext() == null) {
                    return null;
                }
                mLL_Curr = mLL_Curr.getNext();
            }
            return mLL_Curr.getData();
        }
        return mLL_Curr;
    }

    /**
     * Returns the size of the list
     *
     * @return
     */
    public int size() {
        return getCtr();
    }

    /**
     * Method to remove node
     *
     * @param index
     * @return
     */
    public boolean remove(int index) {
        if (index < 0 || index > size()) {  //Exit if out of range
            return false;
        }
        Node mLL_Curr = head;
        if (head != null) {
            for (int i = 0; i < index; i++) {
                if (mLL_Curr.getNext() == null) {
                    return false;
                }
                mLL_Curr = mLL_Curr.getNext();
            }
            mLL_Curr.setNext(mLL_Curr.getNext().getNext());
            decCtr();   //Decrement number of elements
            return true;
        }
        return false;
    }

    /**
     * Clears list by calling remove in a loop
     * @param size
     */
    public void clear(int size){
        for(int i = 0; i <= size; i++){
            remove(i);
        }
    }

    /**
     * checks if list is completely empty by checking if the head is null
     * @return head location if exists, null otherwise.
     */
    public Node checkNull(){
        return head;
    }
}
