package org.example;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class App {
    public static void main(String[] args) {
        try {
            Logger log = LogManager.getLogger(App.class);
            log.error("error level message");
        } catch (Exception e) {
            System.out.println(e.getClass() + ": " + e.getMessage());
        }
    }
}
