package fr.lernejo.logger;

public class LoggerFactory {
    public static Logger getLogger(String name){
        return new ContextualLogger(new FileLogger("/home/soldier/developpement/logs_tp/logs.txt"), name);
    }
}
