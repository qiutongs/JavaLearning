package com.qiutongs.java.clazz;

public class OutterClass1 {
    private int i;

    private void outterPrint() {
	System.out.println(i);
    }
    
    public void print() {
	System.out.println("public");
    }

    static class StaticNestedClass1 {
	// cannot reference to non-static member of outter class
	// private int innerI = i + 1;

	private void print() {
	    // cannot reference to non-static method of outter class
	    // outterPrint();
	}
    }

    public static void main(String[] args) {
	OutterClass1.StaticNestedClass1 instance = new OutterClass1.StaticNestedClass1();
    }
}
