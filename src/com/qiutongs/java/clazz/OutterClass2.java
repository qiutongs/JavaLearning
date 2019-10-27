package com.qiutongs.java.clazz;

public class OutterClass2 {
    private int i;

    private void outterPrint() {
	System.out.println(i);
    }

    class InnerClass2 {
	// can access member variable of outter class
	private int innerI = i + 1;

	// can access member method of outter class
	private void print() {
	    outterPrint();
	}
    }

    public static void main(String[] args) {
	OutterClass2 outterObj = new OutterClass2();
	OutterClass2.InnerClass2 instance = outterObj.new InnerClass2();
    }
}
