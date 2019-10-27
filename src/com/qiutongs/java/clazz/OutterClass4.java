package com.qiutongs.java.clazz;

public class OutterClass4 {
    private static void test() {
	class Local {
	    
	}
	System.out.println(Local.class.getName());
    }
    
    // Local Class
    public static void main(String[] args) {
	class Local {
	    
	}

	//com.qiutongs.java.clazz.OutterClass3$1Local
        System.out.println(Local.class.getName());
        
        //com.qiutongs.java.clazz.OutterClass3$2Local
        test();
    }
}
