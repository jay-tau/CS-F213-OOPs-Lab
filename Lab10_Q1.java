/*
 * You are playing the Bulls and Cows game with your friend.
 *
 * You write down a secret number and ask your friend to guess what the number is. When your friend makes a guess, you provide a hint with the following information:
 *
 * The number of “bulls”, which are digits in the guess that are in the correct position. The number of “cows” , which are digits in the guess that are in your secret number but are located in the wrong position. Specifically, the non-bull digits in the guess that could be arranged such that they become bulls.
 *
 * Given the secret number secret and your friend’s guess, return the hint for your friend’s guess.
 *
 * The hint should be formatted as “xAyB”, where x is the number of bulls and y is the number of cows. Note that both secret and guess may contain duplicate digits.
 *
 * Input format:
 * 1st line is the secret string.
 * 2nd line is the guess string.
 *
 * Example:
 * Input
 * “1807”
 * “7810”
 *
 * Output
 * “1A3B”
 */

import java.util.*;

public class Lab10_Q1 {
    public static String getHint(String secret, String guess) {
        int bulls = 0;
        HashMap<Character, Integer> letter_count_secret = new HashMap<>();
        HashMap<Character, Integer> letter_count_guess = new HashMap<>();

        for (int i = 0; i < secret.length(); i++) {
            // Add to letter_count
            char secret_char = secret.charAt(i);
            char guess_char = guess.charAt(i);

            if (letter_count_secret.containsKey(secret_char))
                letter_count_secret.put(secret_char, (letter_count_secret.get(secret_char) + 1));
            else
                letter_count_secret.put(secret_char, 1);

            if (letter_count_guess.containsKey(guess_char))
                letter_count_guess.put(guess_char, (letter_count_guess.get(guess_char) + 1));
            else
                letter_count_guess.put(guess_char, 1);

            if (secret_char == guess_char)
                bulls++;
        }

        // Print hashmaps
        /*
         * Iterator iter_secret = (letter_count_secret.keySet()).iterator();
         * while (iter_secret.hasNext()) {
         * Character key = (Character) iter_secret.next();
         * System.out.println("" + (key) + " : " + letter_count_secret.get(key));
         * }
         * System.out.println();
         * Iterator iter_guess = (letter_count_guess.keySet()).iterator();
         * while (iter_guess.hasNext()) {
         * Character key = (Character) iter_guess.next();
         * System.out.println("" + (key) + " : " + letter_count_guess.get(key));
         * }
         */

        Iterator iter_guess = (letter_count_guess.keySet()).iterator();
        int cows = 0;
        while (iter_guess.hasNext()) {
            Character key = (Character) iter_guess.next();
            if (letter_count_secret.containsKey(key)) {
                // System.out.println(key + " count: " + (Math.min(letter_count_secret.get(key),
                // letter_count_guess.get(key))));
                cows += Math.min(letter_count_secret.get(key), letter_count_guess.get(key));
            }
        }
        cows -= bulls;
        return (bulls + "A" + cows + "B");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String secret = sc.nextLine();
        String guess = sc.nextLine();

        System.out.println(getHint(secret, guess));
        sc.close();
    }
}
