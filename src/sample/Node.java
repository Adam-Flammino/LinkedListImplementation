package sample;

/**
 * @Course: SDEV 250 ~ Java Programming I
 * @Author Name: Adam Flammino
 * @Assignment Name: aflammino_week11
 * @Date: Apr 20, 2017
 * @Subclass Node Description: gets and sets data for LinkedList class
 */
public class Node {
    //Declarations
    Node next;      //Next node reference if exists - else Null
    Object data;    //Data of any type

    /**
     * Constructor
     * @param dataValue
     */
    public Node(Object dataValue) {
        next = null;
        data = dataValue;
    }

    /**
     * Get method to return data
     * @return data
     */
    public Object getData() {
        return data;
    }

    /**
     * Set method to set data
     * @param dataValue
     */
    @SuppressWarnings("unused")
    public void setData(Object dataValue) {
        data = dataValue;
    }

    /**
     * Get method to advance to the next node in the LinkedList
     * @return next node
     */
    public Node getNext() {
        return next;
    }

    /**
     * Set method to set the next node in the LinkedList
     * @param nextValue
     */
    public void setNext(Node nextValue) {
        next = nextValue;
    }
}
