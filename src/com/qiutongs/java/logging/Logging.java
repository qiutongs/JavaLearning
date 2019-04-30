package com.qiutongs.java.logging;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Logging {

    public static void main(String[] args) {
	System.out.println(System.getProperty("java.util.logging.manager"));
	LogManager logManager = LogManager.getLogManager();
	System.out.println(logManager);
        Logger logger = logManager.getLogger(Logging.class.getName());
        System.out.println(logger);
    }

}
