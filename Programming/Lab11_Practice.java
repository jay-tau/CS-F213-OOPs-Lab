/*
 * Given a string str and an integer K, find whether the string can be changed into a pangram after at most k operations. A pangram is a sentence containing every letter in the english alphabet. A single operation can be used to swap an existing alphabetic character with any other alphabetic character.
 *
 * Example 1:
 *
 * Input:
 * str = "the quick brown fox jumps over the lazy dog" k = 0
 * Output:
 * 1
 * Explanation:
 * the sentence contains all 26 characters and is already a pangram.
 *
 * Example 2:
 *
 * Input:
 * str = "aaaaaaaaaaaaaaaaaaaaaaaaaa"
 * k = 25
 * Output:
 * 1
 * Explanation: The word contains 26 instances of 'a'. Since only 25 operations are allowed. We can keep 1 instance and change all others to make str a pangram.
 */

import java.util.*;

class Lab11_Practice {

    // Returns true if the string
    // is pangram else false
    public static boolean checkPangram(String str, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (map.containsKey(ch))
                    map.put(ch, map.get(ch) + 1);
                else
                    map.put(ch, 1);
            }
        }
        ArrayList<Character> key_list = new ArrayList<Character>(map.keySet());
        if ((key_list.size() + k) >= 26)
            return true;
        else
            return false;
    }

    // Driver Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int k = sc.nextInt();

        if (checkPangram(str, k) == true)
            System.out.print(str + " is a pangram.");
        else
            System.out.print(str + " is not a pangram.");
        sc.close();
    }
}