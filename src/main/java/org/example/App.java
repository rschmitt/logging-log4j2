package org.example;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.appender.AbstractAppender;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Logger logger = (Logger) LogManager.getLogger(App.class);
        TestAppender testAppender = new TestAppender();

        logger.addAppender(testAppender);
        logger.setLevel(Level.INFO);
        testAppender.start();

        logger.info("Initializing Log4j 1.2 API...");
        org.apache.log4j.LogManager.getLogger(App.class);
        logger.info("Log4j 1.2 API initialized.");

        System.out.printf("Recorded %,d events (expected 2)%n", testAppender.getLogEvents());
    }

    static class TestAppender extends AbstractAppender {
        private final List<LogEvent> logEvents;

        public TestAppender() {
            super("TestAppender", null, null, true, null);
            this.logEvents = new ArrayList<>();
        }

        @Override
        public void append(LogEvent event) {
            logEvents.add(event);
        }

        public int getLogEvents() {
            return logEvents.size();
        }
    }}
