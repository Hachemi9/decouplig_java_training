package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player{
    Logger logger = LoggerFactory.getLogger("player");
    long min=Long.MIN_VALUE;
    long max=Long.MAX_VALUE;
    long num;
    @Override
    public long askNextGuess() {
        num=(max+min)/2;
        logger.log("tentative :"+num);
        return num;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if(lowerOrGreater) {
            logger.log("plus grand");
            min=num;
        }
        else {
            logger.log("plus petit");
            max=num;
        }
    }
}
