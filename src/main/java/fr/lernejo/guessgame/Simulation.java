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
            logger.log("Win");
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

            long endTime = System.currentTimeMillis();
            long mm = ((endTime-startTime)/600000);
            long ss = ((endTime-startTime)/1000);
            logger.log(mm+" mm "+ss+" ss "+((endTime-startTime)-(ss*1000)-(mm*600000))+" SSS");
        }
}
