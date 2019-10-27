package com.qiutongs.java.clazz;

public class OutterClass3 {

    public void print() {
	System.out.println("print");
    }

    // Anonymous class
    public static void main(String[] args) {
	OutterClass3 oc1 = new OutterClass3() {
	    @Override
	    public void print() {
		System.out.println("oc1 public");
	    }
	};

	OutterClass3 oc2 = new OutterClass3() {
	    @Override
	    public void print() {
		System.out.println("oc2 public");
	    }
	};
	
        //com.qiutongs.java.clazz.OutterClass3$1
	System.out.println(oc1.getClass().getName());
        
        //com.qiutongs.java.clazz.OutterClass3$2
	System.out.println(oc2.getClass().getName());
    }
}
