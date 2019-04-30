package com.qiutongs.java.map;

import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
	TreeMap<Integer, String> tree = new TreeMap<>();
	
	tree.put(6,  "six");
	tree.put(10, "ten");
	tree.put(1, "one");
	
	System.out.println(tree.firstEntry());
	System.out.println(tree.lastEntry());
    }
}
