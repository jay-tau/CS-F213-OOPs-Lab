import java.io.*;
import java.util.*;

class Lab11_Practice {

    // Returns true if the string
    // is pangram else false
    public static boolean checkPangram(String str, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                } else {
                    map.put(ch, 1);
                }
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
    }
}