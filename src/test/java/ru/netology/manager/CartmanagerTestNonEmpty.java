package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Purchaseitem;

import static org.junit.Assert.assertArrayEquals;

class CartManagerTestNonEmpty {
    @Test
    public void shouldRemoveIfExists() {
        CartManager manager = new CartManager();
        int idToRemove = 1;
        Purchaseitem first = new Purchaseitem(1, 1, "first", 1, 1);
        Purchaseitem second = new Purchaseitem(2, 2, "second", 1, 1);
        Purchaseitem third = new Purchaseitem(3, 3, "third", 1, 1);
        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.removeById(idToRemove);

        Purchaseitem[] actual = manager.getAll();
        Purchaseitem[] expected = new Purchaseitem[]{third, second};

//    assertEquals(expected, actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        CartManager manager = new CartManager();
        int idToRemove = 4;
        Purchaseitem first = new Purchaseitem(1, 1, "first", 1, 1);
        Purchaseitem second = new Purchaseitem(2, 2, "second", 1, 1);
        Purchaseitem third = new Purchaseitem(3, 3, "third", 1, 1);
        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.removeById(idToRemove);

        Purchaseitem[] actual = manager.getAll();
        Purchaseitem[] expected = new Purchaseitem[]{third, second, first};

        Assertions.assertArrayEquals(expected, actual);
    }
}