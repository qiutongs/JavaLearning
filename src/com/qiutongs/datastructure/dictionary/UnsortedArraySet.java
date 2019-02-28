package com.qiutongs.datastructure.dictionary;

import com.qiutongs.datastructure.array.DynamicArray;

public class UnsortedArraySet<I extends Comparable<I>> implements Set<I> {
    private final DynamicArray<I> array;

    public UnsortedArraySet() {
        this.array = new DynamicArray<>();
    }

    @Override
    public void add(I item) {
        array.add(item);
    }

    @Override
    public boolean remove(I item) {
        int index = array.search(item);

        if (index == -1) {
            return false;
        } else {
            array.remove(index);
            return true;
        }
    }

    @Override
    public boolean search(I item) {
        return array.search(item) != -1;
    }

    public static void main(String[] args) {
        UnsortedArraySet<Integer> set = new UnsortedArraySet<>();

        set.add(1);
        set.add(2);

        System.out.println("Searching existed number: " + set.search(1));
        System.out.println("Searching not existed number: " + set.search(3));

        System.out.println("Remove existed number: " + set.remove(1));
        System.out.println("Searching again: " + set.search(1));
    }

}
