package com.qiutongs.datastructure;

import java.util.Random;

public class Array extends DataStructure {

	private final Random rand;

	private DynamicArray<Integer> array;

	public Array() {
		this.rand = new Random();

		// Register "get"
		resiger(new Operation() {

			@Override
			public void invoke() {
				// Index is within array's boundary
				array.get(rand.nextInt(array.size()));
			}

			@Override
			public String getName() {
				return "Get";
			}
		});

		// Register "Search"
		resiger(new Operation() {

			@Override
			public void invoke() {
				array.search(rand.nextInt());
			}

			@Override
			public String getName() {
				return "Search";
			}
		});
	}

	@Override
	void initialize(int dataCount) {
		// Discard previous array and create new object
		array = new DynamicArray<>();

		for (int i = 0; i < dataCount; i++) {
			array.add(rand.nextInt());
		}
	}

}
