package arrays.two_pointer.twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * ================================================================
 * Problem      : Two Sum
 * LeetCode     : #1
 * Difficulty   : Easy
 *
 * Pattern(s)
 * 1. Brute Force
 * 2. HashMap (Optimal for Unsorted Array)
 * 3. Two Pointers (Optimal for Sorted Array)
 *
 * Time Complexity
 * ------------------------------------------------
 * Brute Force : O(n²)
 * HashMap     : O(n)
 * Two Pointer : O(n)
 *
 * Space Complexity
 * ------------------------------------------------
 * Brute Force : O(1)
 * HashMap     : O(n)
 * Two Pointer : O(1)
 *
 * Interview Tips
 * ------------------------------------------------
 * • Clarify whether the interviewer expects indices or values.
 * • HashMap is preferred for unsorted arrays.
 * • Two Pointer works only for sorted arrays.
 * ================================================================
 */

public class TwoSum {

    // ============================================================
    // Approach 1 : Brute Force
    // ============================================================
    // Time  : O(n²)
    // Space : O(1)
    //
    // REVIEW:
    // - Best approach to explain first during interviews.
    // - Demonstrates your thought process before optimization.
    // - Returns VALUES (not indices).
    // ============================================================

    public static int[] twoSumBrute(int[] nums, int target) {

        // REVIEW:
        // Two Sum requires at least two numbers.
        if (nums == null || nums.length < 2) {
            return new int[]{};
        }

        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    return new int[]{nums[i], nums[j]};
                }
            }
        }

        // REVIEW:
        // No valid pair found.
        return new int[]{-1, -1};
    }


    // ============================================================
    // Approach 2 : HashMap (Optimal)
    // ============================================================
    // Time  : O(n)
    // Space : O(n)
    //
    // REVIEW:
    // - Works for UNSORTED arrays.
    // - Returns INDICES (LeetCode variant).
    // - Preferred solution in interviews.
    // ============================================================

    public static int[] twoSumHashMap(int[] nums, int target) {

        if (nums == null || nums.length < 2) {
            return new int[]{};
        }

        Map<Integer, Integer> indexByValue = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int currentNumber = nums[i];
            int complement = target - currentNumber;

            // REVIEW:
            // Check before inserting.
            // Prevents using the same element twice.
            if (indexByValue.containsKey(complement)) {
                return new int[]{
                        indexByValue.get(complement),
                        i
                };
            }

            indexByValue.put(currentNumber, i);
        }

        return new int[]{-1, -1};
    }


    // ============================================================
    // Approach 3 : Two Pointers
    // ============================================================
    // Time  : O(n)
    // Space : O(1)
    //
    // IMPORTANT:
    // Works ONLY when the input array is already sorted.
    //
    // REVIEW:
    // Returns VALUES instead of indices.
    // If original indices are required, prefer the HashMap solution.
    // ============================================================

    public static int[] twoSumTwoPointer(int[] nums, int target) {

        if (nums == null || nums.length < 2) {
            return new int[]{};
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int sum = nums[left] + nums[right];

            if (sum == target) {
                return new int[]{
                        nums[left],
                        nums[right]
                };
            }

            // Since the array is sorted,
            // move pointers based on the current sum.
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }


    public static void main(String[] args) {

        int[] sortedNumbers = {2, 7, 11, 15};
        int target = 26;

        System.out.println("Brute Force : "
                + Arrays.toString(twoSumBrute(sortedNumbers, target)));

        System.out.println("HashMap     : "
                + Arrays.toString(twoSumHashMap(sortedNumbers, target)));

        System.out.println("Two Pointer : "
                + Arrays.toString(twoSumTwoPointer(sortedNumbers, target)));
    }
}