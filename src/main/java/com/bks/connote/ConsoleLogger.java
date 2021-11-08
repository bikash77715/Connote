package com.bks.connote;

import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class ConsoleLogger {
    private Logger logger;
    public ConsoleLogger() {
        this.logger = Logger.getLogger(ConsoleLogger.class.getName());
        this.logger.setLevel(Level.INFO);
    }

    public void log(String msg){
        logger.log(Level.INFO, msg);
    }
}
