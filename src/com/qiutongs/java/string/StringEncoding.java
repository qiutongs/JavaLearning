package com.qiutongs.java.string;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class StringEncoding {
    public static void main(String[] args) throws UnsupportedEncodingException {
	byte[] b = {0x41};

	String s1 = new String(b);
	String s2 = new String(b, "UTF16");
	System.out.println(s1);
	System.out.println(s2);
	
	char[] a = {'A'};
	String s3 = new String(a);
	System.out.println(s3);
	
	System.out.println(Arrays.toString(s3.getBytes()));
	System.out.println(s3.getBytes("UTF-16").length);
	System.out.println(Arrays.toString(s3.getBytes("UTF-16")));
	
	//int maxX = minX = 3;
	//int c, v;
	//c = v = 3; 
	int i = 100;
	char[][] board = {{'1'}};
	board[0][0] = '0' + 1;
	System.out.println(board[0][0]);
	
    }
}
