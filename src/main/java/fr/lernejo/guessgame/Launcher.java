package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextLong(100);
        Player player = new HumanPlayer();
        Simulation simu = new Simulation(player);
        simu.initialize(randomNumber);
        simu.loopUntilPlayerSucceed();
    }
}
