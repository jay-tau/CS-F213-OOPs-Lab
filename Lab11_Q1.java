import java.util.*;

public class Lab11_Q1 {

    public static void solve(String A) {
        Queue<Character> qu = new LinkedList<>();
        HashMap<Character, Integer> letter_count = new HashMap<>();
        String B = "";
        for (int i = 0; i < A.length(); i++) {
            char current_char = A.charAt(i);
            qu.add(current_char);
            if (letter_count.containsKey(current_char))
                letter_count.put(current_char, (letter_count.get(current_char) + 1));
            else
                letter_count.put(current_char, 1);
            while (!qu.isEmpty() && letter_count.get(qu.peek()) > 1) { // Remove from queue till we find a character
                                                                       // with a count of 1
                qu.poll();
            }
            if (qu.isEmpty()) // No character with count 1
                B += "#";
            else
                B += (qu.peek()); // Add first character with count 1
        }
        System.out.println(B);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        solve(A);
        sc.close();
    }
}