package com.qiutongs.datastructure;

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
			capacity *= SCALE_FACTOR;
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

}
