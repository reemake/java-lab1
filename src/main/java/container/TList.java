package container;

/**
 * Класс, описывающий связный список
 * @author Никита Сафонов "reemake3@gmail.com"
 * @see Item
 */
public class TList <T> {

    /** Размер списка */
    private static int size;

    /** Головной элемент списка */
    private Item head;

    /** Конструктор для объекта класса TList */
    public TList() {
        this.head = null;
        size = 0;
    }

    /** Проверка списка на пустоту
     * @return true если список пустой, иначе false
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /** @return размер списка */
    public int getSize() {
        return size;
    }

    /**
     * Добавление элемента в начало списка
     * @param val значение добавляемого элемента
     */
    private void addToHead(T val) {
        Item p = new Item();
        p.setValue(val);
        p.setNext(head);
        head = p;
        size++;
    }

    /**
     * Добавление элемента в конец списка
     * @param val значение добавляемого элемента
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
     * Добавление элемента в список по указанной позиции
     * @param val значение добавляемого элемента
     * @param index позиция добавляемого элемента
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
     * Поиск позиции
     * @param n указанная позиция
     * @return obj узел, который следует после указанной позиции
     */
    private Item findPosition(int n) {
        Item obj = new Item();
        obj = head;
        for (int i = 0; i < n - 2; i++)
            obj = obj.getNext();
        return obj;
    }

    /**
     * Добавление элемента в список по значению
     * @param val значение добавляемого элемента
     * @return true при успешной вставке, иначе false
     */
    public boolean addElem(T val) {
        if (isEmpty()) addToHead(val);
        else addToTail(val);
        return true;
    }

    /**
     * Добавление элемента в список
     * @param val значение добавляемого элемента
     * @param n указанная позиция
     * @return true при успешной вставке, иначе false
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

    /** Удаление элемента из начала списка */
    private void deleteFromHead() {
        Item p = new Item();
        p = head;
        head = head.getNext();
        p = null;
        size--;
        if (size == 0) head = null;
    }

    /** Удаление элемента из конца списка
     * @param indexOfLastOne позиция последнего элемента
     */
    private void deleteFromTail(int indexOfLastOne) {
        Item p = new Item();
        p = findPosition(indexOfLastOne);
        p.setNext(null);
        p = null;
        size--;
    }

    /** Удаление элемента по указанной позиции
     * @param index указанная позиция
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


    /** Удаление элемента из списка
     * @param n указанная позиция
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

    /** Извлечение элемента из списка
     * @param n указанная позиция
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



