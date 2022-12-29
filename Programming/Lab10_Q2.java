/*
 * You are given two sorted LinkedList L1 and L2.
 *
 * Merge the two sorted LinkedList into a single sorted LinkedList. The list should be made by Splicing together the nodes of the first two Lists.
 *
 * Return the Linked List and print it in the main function.
 *
 * Input Format :
 *
 * The First line denotes the number of elements in List 1
 * The 2nd Line denotes the elements in List 1 The 3rd Line Denotes the number of elements in List 2 The 4th Line denotes the elements in List 2.
 *
 * Example : Input
 * 3
 * 1 2 3
 * 6
 * 4 5 6 7 8 9
 *
 * Output 1 2 3 4 5 6 7 8 9
 */

import java.util.*;

public class Lab10_Q2 {

    public static LinkedList<Integer> mergeTwoLists(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        LinkedList<Integer> mergedList = new LinkedList<Integer>();
        while (!l1.isEmpty() || !l2.isEmpty()) {
            if (l1.isEmpty())
                mergedList.add(l2.removeFirst());
            else if (l2.isEmpty())
                mergedList.add(l1.removeFirst());
            else if (l1.getFirst() < l2.getFirst())
                mergedList.add(l1.removeFirst());
            else
                mergedList.add(l2.removeFirst());
        }
        return mergedList;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> L1 = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            L1.add(sc.nextInt());
        }
        int m = sc.nextInt();
        LinkedList<Integer> L2 = new LinkedList<Integer>();
        for (int i = 0; i < m; i++) {
            L2.add(sc.nextInt());
        }
        LinkedList<Integer> L3 = new LinkedList<Integer>();
        L3 = mergeTwoLists(L1, L2);

        for (int i = 0; i < L3.size(); i++) {
            System.out.print(L3.get(i) + " ");
        }
        sc.close();

    }

}
