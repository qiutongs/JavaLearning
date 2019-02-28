package com.qiutongs.datastructure.array;

public class SortedDynamicArray<I extends Comparable<I>> extends DynamicArray<I> implements SortedArray<I> {

    @Override
    public void add(I item) {

    }

    @SuppressWarnings("unchecked")
    private int binaryAdd(I item, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return -1;
        }

        int midIndex = (startIndex + endIndex) / 2;

        int compareResult = ((I) array[midIndex]).compareTo(item);

        if (compareResult == 0) {
            return midIndex;
        } else if (compareResult < 0) {
            return binarySearch(item, midIndex + 1, endIndex);
        } else {
            return binarySearch(item, startIndex, midIndex - 1);
        }
    }
    
    @Override
    public int search(I item) {
        return binarySearch(item, 0, size - 1);
    }

    @SuppressWarnings("unchecked")
    private int binarySearch(I item, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return -1;
        }

        int midIndex = (startIndex + endIndex) / 2;

        int compareResult = ((I) array[midIndex]).compareTo(item);

        if (compareResult == 0) {
            return midIndex;
        } else if (compareResult < 0) {
            return binarySearch(item, midIndex + 1, endIndex);
        } else {
            return binarySearch(item, startIndex, midIndex - 1);
        }
    }
}