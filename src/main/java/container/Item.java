package container;

/**
 * Класс, описывающий структуру узла связного списка
 * @author Никита Сафонов "reemake3@gmail.com"
 * @see TList
 */
public class Item <T> {

    /** Поле значения */
    private T value;

    /** Ссылка на следующий элемент списка */
    private Item <T> next;

    /** Конструктор для объекта класса Item */
    public Item() {
        this.next = null;
    }

    /** @return значение узла */
    public T getValue() {
        return value;
    }

    /** Сеттер-метод для значения узла */
    public void setValue(T val) {
        this.value = val;
    }

    /** @return ссылка на следующий узел */
    public Item<T> getNext() {
        return next;
    }

    /** Сеттер-метод для ссылки на соседний узел */
    public void setNext(Item<T> obj) {
        this.next = obj;
    }
}

