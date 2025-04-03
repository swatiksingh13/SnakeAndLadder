package in.game;

public class DiceUtility {
    public static int roll() {
        int min = 1;
        int max = 6;
        return (int) Math.floor(Math.random() * (max - min + 1) + min);


        //TODO: Modify the above function to return a random value based on the number of dice.
        /* code for multiple dice
        public class DiceUtility {
         public static int roll(int numberOfDices) {
        int min = 1 * numberOfDices;
        int max = numberOfDices * 6;

        return (int) Math.floor(Math.random() * (max - min + 1) + min);
        }
        }

        or

        public class DiceUtil {
        public static int roll(int numberOfDices) {
        int sum = 0;
        for (int i = 0; i < numberOfDices; i++) {
            sum += (int) (Math.random() * 6) + 1;
        }
        return sum; }}

       */

    }
}
/*
 Math.random() -> [0,1) Inclusive 0 and exclusive 1
min = 1
max = 6

 0.6 * 6 + 1 => 4.6 => 4
 0.1 * 6 + 1 => 1.6 => 1
 0 * 6 + 1 => 1
 0.25 * 6 + 1 => 2

min = 1
max = 12

0.2 * 12 + 1 => 4
0.9 * 12 + 1 => 12
0.99999 * 12 + 1 =>

 */