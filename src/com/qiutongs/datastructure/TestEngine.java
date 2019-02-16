package com.qiutongs.datastructure;

import java.util.ArrayList;

public class TestEngine {
    
    static final int[] FULL_DATA_SET = { 100, 1000, 10000, 100000, 200000, 400000 };
    static final int[] SMALL_DATA_SET = { 100, 1000, 10000 };
    
	// How many times this engine runs for same test suite.
	static final int TEST_LOOP_COUNT = 10;

	// How many times this engine tests for same single operation.
	static final int OPERATION_COUNT = 10000;

	// Each element is the amount of data in one group of tests.
	private final int[] dataSet;

	// Data structure to test
	private final DataStructure dataStructure;

	public TestEngine(int[] dataSet, DataStructure dataStructure) {
		this.dataSet = dataSet;
		this.dataStructure = dataStructure;
	}

	public void run() {
		ArrayList<Operation> operationList = dataStructure.getOperationList();

		double[][] result = new double[dataSet.length][operationList.size()];

		// Initialize result to 0.
		for (int j = 0; j < dataSet.length; j++) {
			for (int k = 0; k < operationList.size(); k++) {
				result[j][k] = 0;
			}
		}

		// For each iteration of running test suite.
		for (int i = 0; i < TEST_LOOP_COUNT; i++) {
			// For each data set
			for (int j = 0; j < dataSet.length; j++) {
				// First, initialize data set
				dataStructure.initialize(dataSet[j]);

				// For each operation, get its latency result and add up to corresponding group.
				for (int k = 0; k < operationList.size(); k++) {
					result[j][k] += runSingleOperation(operationList.get(k));
				}
			}
		}

		// Divide result by "loop count".
		for (int j = 0; j < dataSet.length; j++) {
			for (int k = 0; k < operationList.size(); k++) {
				result[j][k] /= TEST_LOOP_COUNT;
			}
		}

		output(result);
	}

	// Run same operation multiple times and get average result.
	private double runSingleOperation(Operation op) {
		double start = System.nanoTime();
		for (int i = 0; i < OPERATION_COUNT; i++) {
			op.invoke();
		}
		double end = System.nanoTime();
		return (end - start) / (double) OPERATION_COUNT;
	}

	// Output a formatted string (Youdao Note)
	private void output(double[][] result) {
		ArrayList<Operation> operationList = dataStructure.getOperationList();

		StringBuilder sb = new StringBuilder();

		// First row (table header)
		for (Operation op : operationList) {
			sb.append("  |  " + op.getName());
		}
		sb.append('\n');

		// Second row (horizontal line)
		sb.append("---");
		for (Operation op : operationList) {
			sb.append("|---");
		}
		sb.append('\n');

		// Actual content
		for (int i = 0; i < result.length; i++) {
			// First column: number of data
			sb.append(dataSet[i]);

			for (int j = 0; j < result[i].length; j++) {
				sb.append(" | ");
				sb.append((int) result[i][j]);
			}

			sb.append('\n');
		}

		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		/*
		 * | Get | Search 
		 * ---|---|--- 
		 * 100 | 38 | 284 
		 * 1000 | 15 | 747 
		 * 10000 | 15 | 10742
		 * 100000 | 23 | 107372 
		 * 200000 | 13 | 283510 
		 * 400000 | 15 | 682060
		 */
		Array array = new Array();
		TestEngine engine = new TestEngine(SMALL_DATA_SET, array);

		engine.run();
	}

}
