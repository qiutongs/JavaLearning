package com.qiutongs.datastructure;

import java.util.ArrayList;

public abstract class DataStructure {
	// A data structure holds a list of operations.
	protected final ArrayList<Operation> operationList;

	public DataStructure() {
		this.operationList = new ArrayList<>();
	}

	protected void resiger(Operation op) {
		operationList.add(op);
	}

	public ArrayList<Operation> getOperationList() {
		return operationList;
	}

	// Initialize this data structure with specified amount
	abstract void initialize(int dataCount);
}
