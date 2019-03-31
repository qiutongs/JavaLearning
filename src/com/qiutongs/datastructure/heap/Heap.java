package com.qiutongs.datastructure.heap;

import java.util.Arrays;

public class Heap<I extends Comparable<I>> {
    // last parent (internal node) = last leaf's parent = ((heap_size - 1) - 1 ) / 2
    // starting from heap_size/2, are the leaves
    private I[] items;

    public Heap(I[] items) {
        this.items = items;

        for (int i = items.length - 1; i >= 0; i--) {
            heapifyDown(i);
        }
    }

    public I getMin() {
        return items[0];
    }

    public void update(int i, I newItem) {
        I currentItem = items[i];
        items[i] = newItem;

        if (newItem.compareTo(currentItem) < 0) {
            heapifyUp(i);
        } else if (newItem.compareTo(currentItem) > 0) {
            heapifyDown(i);
        }
    }

    private void heapifyUp(int p) {
        while (p > 0) {
            int parent = (p - 1) / 2;

            if (items[p].compareTo(items[parent]) < 0) {
                swap(p, parent);
                p = parent;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int p) {
        while (p < items.length / 2) {
            int minIndex = getMinIndex(p);

            if (p == minIndex) {
                break;
            }

            swap(p, minIndex);
            p = minIndex;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

    private int getMinIndex(int parentIndex) {
        int left = parentIndex * 2 + 1;
        int right = parentIndex * 2 + 2;

        I min = items[parentIndex];
        int result = parentIndex;

        if (items[left].compareTo(min) < 0) {
            min = items[left];
            result = left;
        }

        if (right < items.length && items[right].compareTo(min) < 0) {
            min = items[right];
            result = right;
        }

        return result;
    }

    private void swap(int index1, int index2) {
        I temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

    public static void main(String[] args) {
        Integer numbers[] = { 113, 400, 818, 612, 411, 311, 412, 420 };
        Heap<Integer> heap = new Heap<>(numbers);
        System.out.println(heap);

        System.out.println("update a smaller value");
        heap.update(3, 10);
        System.out.println(heap);

        System.out.println("update a bigger value");
        heap.update(0, 1000);
        System.out.println(heap);
    }
}
