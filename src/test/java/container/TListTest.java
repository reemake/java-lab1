package container;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TListTest {

    TList<Integer> list;

    @BeforeEach
    public void setUp() { list = new TList<>(); }

    @Test
    void testIsEmptyTrue() {
        assertEquals(true, list.isEmpty());
    }

    @Test
    void testIsEmptyFalse() {
        list.addElem(4);
        list.addElem(3);
        list.addElem(7);

        assertEquals(false, list.isEmpty());
    }

    @Test
    void testGetElemSuccessful() {
        list.addElem(4);
        list.addElem(3);
        list.addElem(7);
        list.addElem(1, 1);

        assertEquals(7, list.getElem(4).getValue());
    }

    @Test
    void testGetElemOutOfRange() {
        list.addElem(5);
        assertEquals(null, list.getElem(0));
    }

    @Test
    void testAddElemByValue() {
        assertEquals(true, list.addElem(7));
    }

    @Test
    void testAddElemByIndex() {
        list.addElem(4);
        list.addElem(5);
        list.addElem(6);
        list.addElem(7);
        list.addElem(8, 3);

        assertEquals(8, list.getElem(3).getValue());
    }

    @Test
    void testDeleteElemSuccessful() {
        list.addElem(4);
        list.addElem(5);
        list.addElem(6);
        list.addElem(7);

        assertEquals(true, list.deleteElem(3));
    }

    @Test
    void testDeleteElemFromEmptyList() {
        assertEquals(false, list.deleteElem(4));
    }
}