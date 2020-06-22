package com.company.task4;

public class LinkedList {

    LinkedItem first;
    LinkedItem last;
    int size;


    public LinkedList(int[] values) {
        for (int a : values) {
            add(a);
        }
    }

    public LinkedList() {

    }

    public void print() {
        LinkedItem current = first;
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                stringBuilder.append(current.value + "]");
            } else {
                stringBuilder.append(current.value + ",");
                current = current.next;
            }
        }
        System.out.println(stringBuilder.toString());
    }


    //    Добавление элемента в конец
    public void add(int value) {
        LinkedItem l = last;
        LinkedItem newItem = new LinkedItem(value, null, last);
        last = newItem;
        if (l == null)
            first = newItem;
        else
            l.next = newItem;
        size++;
    }

    //  Добавление элемента по индексу
    void add(int index, int value) {
        if (index == size) {
            add(value);
        } else {
            LinkedItem next = getItemByIndex(index);
            LinkedItem prev = next.prev;
            LinkedItem newItem = new LinkedItem(value, next, prev);
            next.prev = newItem;
            if (prev == null) {
                first = newItem;
            } else {
                prev.next = newItem;
            }
            size++;
        }
    }

    //  Удаление элемента по индексу
    void remove(int index) {
        LinkedItem next = getItemByIndex(index).next;
        LinkedItem prev = getItemByIndex(index).prev;
        if (prev != null) {
            prev.next = next;
        } else {
            first = next;
        }
        if (next != null) {
            next.prev = prev;
        } else {
            last = prev;
        }
        size--;
    }

    //  Получение значения элемента по индексу
    public int get(int index) {
        return getItemByIndex(index).value;
    }

    // Изменнеие элемента по индексу
    public void set(int index, int value) {
        getItemByIndex(index).value = value;
    }

    //  Сортировка по возрастанию
    public void sortAcs() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = size - 1; j > i; j--) {
                if (getItemByIndex(j - 1).value > getItemByIndex(j).value) {
                    upSwap(getItemByIndex(j - 1));
                }
            }
        }
    }

    //  Сортировка по убыванию
    public void sortDes() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = size - 1; j > i; j--) {
                if (getItemByIndex(j - 1).value < getItemByIndex(j).value) {
                    upSwap(getItemByIndex(j - 1));
                }
            }
        }
    }

    //  Получение элемента по индексу
    private LinkedItem getItemByIndex(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index < (size / 2)) {
            LinkedItem x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            LinkedItem x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }


    //Перестановка текущего элемента на один вперед
    private void upSwap(LinkedItem swapedUp) {
        LinkedItem swapedDown = swapedUp.next;
        LinkedItem prev = swapedUp.prev;
        LinkedItem next = swapedDown.next;
        if (prev != null) {
            prev.next = swapedDown;
        }
        if (next != null) {
            next.prev = swapedUp;
        }
        swapedDown.prev = prev;
        swapedUp.next = next;
        swapedUp.prev = swapedDown;
        swapedDown.next = swapedUp;
        if (swapedUp.next == null) {
            last = swapedUp;
        }
        if (swapedDown.prev == null) {
            first = swapedDown;
        }
    }

    private static class LinkedItem {
        public int value;
        public LinkedItem next;
        public LinkedItem prev;


        public LinkedItem(int value, LinkedItem next, LinkedItem prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

    }
}

