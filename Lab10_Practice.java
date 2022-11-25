/*
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one or no solution, and you may not use the same element twice. If there are no solutions, Output should be [-1, -1].
 *
 * You can return the answer in any order.
 *
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation:
 * Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 * Sample test Case:
 * Input:
 * 3 6 3 2 4
 * Output:
 * 1 2
 */

import java.util.*;

class Lab10_Practice {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = { -1, -1 };
        // Add all the elements to the map (element, index)
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        // Check if the map contains the complement of the target
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                result[0] = i;
                result[1] = map.get(complement);
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] ans = twoSum(nums, target);
        System.out.println(ans[0] + " " + ans[1]);
        sc.close();
    }
}
