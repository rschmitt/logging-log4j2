package org.example;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class App {
    private static final Logger log = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        log.trace("trace level message");
        log.debug("debug level message");
        log.info("info level message");
        log.warn("warn level message");
        log.error("error level message");
        log.fatal("fatal level message");
    }
}
