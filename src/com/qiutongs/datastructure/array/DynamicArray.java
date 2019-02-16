package com.qiutongs.datastructure.array;

import java.util.Arrays;

import com.qiutongs.datastructure.TestEngine;

public class DynamicArray<I> {
    private static final int INITIAL_CAPACITY = 1;
    private static final int SCALE_FACTOR = 2;

    private Object[] array;
    private int size;
    private int capacity;

    public DynamicArray() {
        this(INITIAL_CAPACITY);
    }

    public DynamicArray(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public void add(I item) {
        if (size == capacity) {
            capacity = capacity == 0 ? 1 : capacity * SCALE_FACTOR;
            Object[] newArray = new Object[this.capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }

        array[size++] = item;
    }

    public I get(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException();
        }

        return (I) array[index];
    }

    public void set(int index, I value) {
        if (index < 0 || index >= size) {
            throw new RuntimeException();
        }

        array[index] = value;
    }

    public I search(I item) {
        for (Object obj : array) {
            if (item.equals(obj)) {
                return (I) obj;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }
    
    public int capacity() {
        return capacity;
    }
    
    @Override
    public String toString() {
        return Arrays.toString(array);
    }
    
    public static void main(String[] args) {
        System.out.println("-------- Dynamic Capacity Illustration --------  ");
        DynamicArray<Integer> array = new DynamicArray<>();
        System.out.println("Initial size: " + array.size());
        System.out.println("Initial capacity: " + array.capacity());
        
        array.add(3);
        System.out.println("Size after adding one number: " + array.size());
        System.out.println("Capacity after adding one number: " + array.size());

        array.add(12);
        System.out.println("Capacity after adding two numbers: " + array.capacity());
        
        array.add(26);
        System.out.println("Capacity after adding three numbers: " + array.capacity());
        System.out.println("Size after adding three numbers: " + array.size());
        
        array.add(56);
        array.add(65);
        System.out.println("Capacity after adding five numbers: " + array.capacity());
        System.out.println("Size after adding five numbers: " + array.size());
        
        System.out.println("-------- Basic add, get, set, search --------  ");
        
        System.out.println("Search existed element: " + array.search(3));
        System.out.println("Search not existed element: " + array.search(2));
        
        System.out.println("Number in index 0: " + array.get(0));
        array.set(0, 6);
        System.out.println("Number in index 0, after set: " + array.get(0));
        System.out.println("Search old element: " + array.search(3));
        System.out.println("Search new element: " + array.search(6));
        
        System.out.println(array);
    }

}
