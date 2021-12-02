package fr.lernejo.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger{
Logger delegateLogger;
String callerClass;

    @Override
    public void log(String message) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        delegateLogger.log(LocalDateTime.now().format(format) + " " + callerClass + " " + message);
    }

    public ContextualLogger(Logger delegateLogger, String callerClass) {
        this.delegateLogger = delegateLogger;
        this.callerClass = callerClass;
    }
}
