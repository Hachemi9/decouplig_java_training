package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {
    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        //TODO implement me
        this.player=player;
    }

    public void initialize(long numberToGuess) {
        //TODO implement me
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        //TODO implement me
        Long test = player.askNextGuess();
        if (test.equals(numberToGuess)) {
            logger.log("Number found");
            return true;
        } else {
            if (test.compareTo(numberToGuess) > 0) {
                player.respond(false);
                return false;
            } else {
                player.respond(true);
                return false;
            }

        }
    }


    public void loopUntilPlayerSucceed(long a) {
        final long startTime = System.currentTimeMillis();
        int i=0;
        //TODO implement me
            boolean test = nextRound();
            while (!test && i<a) {
                test = nextRound();
                i++;
            }
            if (i<a){
                logger.log("le nombre a été trouvé en "+i+" itérations");
            }
            else{
                logger.log("Le nombre n'a pas été trouvé, la limite d'itérations a été atteinte :" +i+" itérations");
            }
            final long endTime = System.currentTimeMillis();
            final long time= endTime - startTime;
            logger.log("Total execution time: " +time/60000+":"+time/1000+"."+time);
        }
}
