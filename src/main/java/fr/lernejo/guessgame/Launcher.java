package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        if (args.length==1 && args[0].equals("-interactive")){
            SecureRandom random = new SecureRandom();
            long randomNumber = random.nextLong(1000);
            Player player = new HumanPlayer();
            Simulation simu = new Simulation(player);
            simu.initialize(randomNumber);
            simu.loopUntilPlayerSucceed(Long.MAX_VALUE);
        }
        else if (args.length==2 && args[0].equals("-auto")){
                boolean isInt; long a=0;
                try {
                    a=Integer.parseInt(args[1]);
                    isInt= true;
                } catch (NumberFormatException e) {
                    isInt= false;
                }
                if (isInt){
                    Player player = new ComputerPlayer();
                    Simulation simu = new Simulation(player);
                    simu.initialize(a);
                    simu.loopUntilPlayerSucceed(1000);
                }else{
                    System.out.println("Syntaxe Error : Le deuxième argument doit être de type numérique");
                }
            }
        else {
            System.out.println("Veuillez lancer le jeu en suivant les consignes suivants : \n " +
                "1/ -interactive : pour lancer le jeu en mode utilisateur \n" +
                "2/ -auto 'number' : pour lancer le jeu en mode robot, 'number' étant le nombre à deviner");
        }
    }
}
