package com.qiutongs.java.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    public static void main(String[] args) {
	ReadWriteLock lock = new ReentrantReadWriteLock();
	lock.readLock();
    }
}
