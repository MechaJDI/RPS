package mechaapps.com.myapplication;

import java.lang.String;
import java.util.Random;

/**
 * Created by JDI on 2/28/2015.
 */
public class GameEngine {

    public GameEngine() {

    }

    //Main process for game workings, takes input and generates output
    public String getInput(String input) {
        int[] player = setChoice(input);
        int[] cpu = cpuChoice();
        String output = result(player, cpu);

        return output;
    }

    //Get input of users
    public int[] setChoice(String input) {
        int[] user_choice = new int[3];
        user_choice[0] = Integer.parseInt(input.substring(0, 1));
        user_choice[1] = Integer.parseInt(input.substring(1, 2));
        user_choice[2] = Integer.parseInt(input.substring(2, 3));
        return user_choice;
    }

    //Generate random picks for CPU
    public int[] cpuChoice() {
        int[] cpu_choice = new int[3];
        Random rand = new Random();
        for (int i =0; i <= cpu_choice.length-1; i++) {
            cpu_choice[i] = rand.nextInt((3-1) + 1) + 1;
        }

        return cpu_choice;
    }

    //Get results of player vs cpu
    public String result(int[] player, int[] cpu){
        String msg = "The match is a tie!";
        int wins = 0;
        int ties = 0;
        int losses = 0;

        for (int i = 0; i <= player.length-1; i++) {
            if (player[i] > cpu[i]) {
                wins++;
            }
            else {
                if (player[i] == 1 && cpu[i] == 3) {
                    wins++;
                }
                else if (player[i] == cpu[i]) {
                    ties++;
                }
                else {
                    losses++;
                }
            }
        }

        if (wins >= 2) {
            msg = "You win!";
        }
        else if (wins == 0 && ties <= 2) {
            msg = "You lose!";
        }
        else if (wins == 1 && ties == 0) {
            msg = "You lose!";
        }
        else if (wins == 1 && ties == 2) {
            msg = "You win!";
        }

        msg += " CPU chose: " + cpu[0] + cpu[1] + cpu[2];

        return msg ;
    }

}
