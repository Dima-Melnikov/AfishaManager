package ru.netology.manager;

import ru.netology.domain.Purchaseitem;

public class CartManager {
    private Purchaseitem[] items = new Purchaseitem[0];

    public void add(Purchaseitem item) {
        // создаём новый массив размером на единицу больше
        int length = items.length + 1;
        Purchaseitem[] tmp = new Purchaseitem[length];
        // itar + tab
        // копируем поэлементно
        // for (int i = 0; i < items.length; i++) {
        //   tmp[i] = items[i];
        // }
        System.arraycopy(items, 0, tmp, 0, items.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Purchaseitem[] getAll() {
        Purchaseitem[] result = new Purchaseitem[items.length];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    // наивная реализация
    public void removeById(int id) {
        int length = items.length - 1;
        Purchaseitem[] tmp = new Purchaseitem[length];
        int index = 0;
        for (Purchaseitem item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        // меняем наши элементы
        items = tmp;
    }
}