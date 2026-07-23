package arrays.two_pointer.rearrange;

import java.util.Arrays;

/*
 * ================================================================
 * Problem      : Rearrange 0s and 1s
 * Pattern      : Two Pointers (Partitioning)
 * Difficulty   : Easy
 *
 * Description
 * ------------------------------------------------
 * Rearrange the binary array so that all 0s appear
 * before all 1s.
 *
 * Time Complexity : O(n)
 * Space Complexity: O(1)
 *
 * Interview Tips
 * ------------------------------------------------
 * • This is NOT a Pair Sum problem.
 * • Think of partitioning the array into two regions.
 * • Move pointers independently.
 * • Swap only when both pointers are pointing to
 *   misplaced elements.
 * ================================================================
 */

public class RearrangeZeroAndOne {

    /**
     * Rearranges the binary array in-place.
     *
     * @param nums input array containing only 0s and 1s
     * @return partitioned array
     */
    public static int[] partitionZeroAndOne(int[] nums) {

        // REVIEW:
        // Partitioning requires at least two elements.
        if (nums == null || nums.length < 2) {
            return nums;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            // Left element is already in the correct partition.
            if (nums[left] == 0) {
                left++;
            }

            // Right element is already in the correct partition.
            else if (nums[right] == 1) {
                right--;
            }

            // Both pointers are pointing to misplaced elements.
            else {

                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }
        }

        return nums;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 0, 1, 0, 1, 0, 1, 0};

        System.out.println(Arrays.toString(partitionZeroAndOne(nums)));
    }
}