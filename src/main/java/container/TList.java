package container;

/**
 * Class which is describing a linked list
 * @author Nikita Safonov, student of AMM VSU, 3rd year, 3rd group
 * @see Item
 */
public class TList <T> {

    /** List size */
    private static int size;

    /** List head */
    private Item head;

    /** Constructor for an object of the TList class */
    public TList() {
        this.head = null;
        size = 0;
    }

    /**
     * Checking a list for emptiness
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Getting list size
     * @return list size
     */
    public int getSize() {
        return size;
    }

    /**
     * Adding an item to the beginning of the list
     * @param val the value of the element to be added
     */
    private void addToHead(T val) {
        Item p = new Item();
        p.setValue(val);
        p.setNext(head);
        head = p;
        size++;
    }

    /**
     * Adding an item to the end of the list
     * @param val the value of the element to be added
     */
    private void addToTail(T val) {
        Item p = new Item();
        Item q = new Item();
        p.setValue(val);
        q = findPosition(size + 1);
        q.setNext(p);
        size++;
        q = null;
    }

    /**
     * Adding an item to the list at a specified position
     * @param val the value of the element to be added
     * @param index position of the element to be added
     */
    private void addByIndex(T val, int index) {
        Item p = new Item();
        Item q = new Item();
        q = findPosition(index);
        p.setNext(q.getNext());
        q.setNext(p);
        p.setValue(val);
        size++;
    }

    /**
     * Position search
     * @param n position
     * @return obj the node that comes after the specified position
     */
    private Item findPosition(int n) {
        Item obj = new Item();
        obj = head;
        for (int i = 0; i < n - 2; i++)
            obj = obj.getNext();
        return obj;
    }

    /**
     * Adding an item to a list by value
     * @param val the value of the element to be added
     * @return true on successful insert, false otherwise
     */
    public boolean addElem(T val) {
        if (isEmpty()) addToHead(val);
        else addToTail(val);
        return true;
    }

    /**
     * Adding an item to the list with an indication of the position to insert
     * @param val the value of the element to be added
     * @param n position
     * @return true on successful insert, false otherwise
     */
    public boolean addElem(T val, int n) {
        if (isEmpty()) return false;
        if (n == 1) {
            addToHead(val);
            return true;
        }
        else if (n >= 2 && n <= size) {
            addByIndex(val, n);
            return true;
        }
        else if (n == size + 1) {
            addToTail(val);
            return true;
        }
        else return false;
    }

    /** Removing an item from the beginning of the list */
    private void deleteFromHead() {
        Item p = new Item();
        p = head;
        head = head.getNext();
        p = null;
        size--;
        if (size == 0) head = null;
    }

    /** Removing an item from the end of the list
     * @param indexOfLastOne position of the last element
     */
    private void deleteFromTail(int indexOfLastOne) {
        Item p = new Item();
        p = findPosition(indexOfLastOne);
        p.setNext(null);
        p = null;
        size--;
    }

    /** Removing an element from a specified position
     * @param index position
     */
    private void deleteByIndex(int index) {
        Item p = new Item();
        Item q = new Item();
        q = findPosition(index);
        p = q.getNext().getNext();
        q.setNext(p);
        p = null;
        q = null;
        size--;
    }


    /** Removing an item from the list
     * @param n position
     */
    public boolean deleteElem(int n) {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return false;
        }
        else if (n == 1) {
            deleteFromHead();
            return true;
        }
        else if (n == size) {
            deleteFromTail(n);
            return true;
        }
        else if (n >= 2 && n < size) {
            deleteByIndex(n);
            return true;
        }
        else return false;
    }

    /** Retrieving an item from a list
     * @param n position
     */
    public Item getElem(int n) {
        if (n < 1 || n > size) {
            System.out.println("Error: out of range.");
            return null;
        }
        else if (n == 1) {
            System.out.println("At position " + n + " is the element: " + head.getValue());
            return head;
        }
        else {
            Item p = new Item();
            p = findPosition(n + 1);
            System.out.println("At position " + n + " is the element: " + p.getValue());
            return p;
        }
    }
}



