package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Purchaseitem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CartManagerTestNonEmptyWithSetup {
    private CartManager manager = new CartManager();
    private Purchaseitem first = new Purchaseitem(1, 1, "first", 1, 1);
    private Purchaseitem second = new Purchaseitem(2, 2, "second", 1, 1);
    private Purchaseitem third = new Purchaseitem(3, 3, "third", 1, 1);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        manager.removeById(idToRemove);

        Purchaseitem[] actual = manager.getAll();
        Purchaseitem[] expected = new Purchaseitem[]{third, second};

//    assertEquals(expected, actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;

        manager.removeById(idToRemove);

        Purchaseitem[] actual = manager.getAll();
        Purchaseitem[] expected = new Purchaseitem[]{third, second, first};

        assertArrayEquals(expected, actual);
    }
}