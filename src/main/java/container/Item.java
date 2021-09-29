package container;

/**
 * Class which is describing the structure of a linked list node
 * @author Nikita Safonov, student of AMM VSU, 3rd year, 3rd group
 * @see TList
 */
public class Item <T> {

    /** Value field */
    private T value;

    /** Link to the next item in the list */
    private Item <T> next;

    /** Constructor for an object of the Item class */
    public Item() {
        this.next = null;
    }

    /**
     * Getter-method for node value
     * @return node value
     */
    public T getValue() {
        return value;
    }

    /** Setter-method for node value */
    public void setValue(T val) {
        this.value = val;
    }

    /**
     * Getter-method for link to next node
     * @return link to next node
     */
    public Item<T> getNext() {
        return next;
    }

    /** Setter-method for link to the next node */
    public void setNext(Item<T> obj) {
        this.next = obj;
    }
}

