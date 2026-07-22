"""
================================================================
Problem      : Two Sum
LeetCode     : #1
Difficulty   : Easy

Pattern(s)
1. Brute Force
2. Hash Map (Optimal for Unsorted Array)
3. Two Pointers (Optimal for Sorted Array)

Time Complexity
------------------------------------------------
Brute Force : O(n²)
Hash Map    : O(n)
Two Pointer : O(n)

Space Complexity
------------------------------------------------
Brute Force : O(1)
Hash Map    : O(n)
Two Pointer : O(1)

Interview Tips
------------------------------------------------
• Clarify whether the interviewer expects indices or values.
• Hash Map is preferred for unsorted arrays.
• Two Pointer works only for sorted arrays.
================================================================
"""

from typing import List


class TwoSum:

    # ============================================================
    # Approach 1 : Brute Force
    # ============================================================
    # Time  : O(n²)
    # Space : O(1)
    #
    # REVIEW:
    # - Good starting point during interviews.
    # - Demonstrates your optimization thought process.
    # - Returns VALUES (not indices).
    # ============================================================

    @staticmethod
    def two_sum_brute(nums: List[int], target: int) -> List[int]:

        # REVIEW:
        # Two Sum requires at least two numbers.
        if nums is None or len(nums) < 2:
            return []

        for i in range(len(nums) - 1):
            for j in range(i + 1, len(nums)):

                if nums[i] + nums[j] == target:
                    return [nums[i], nums[j]]

        # REVIEW:
        # No valid pair found.
        return [-1, -1]

    # ============================================================
    # Approach 2 : Hash Map (Optimal)
    # ============================================================
    # Time  : O(n)
    # Space : O(n)
    #
    # REVIEW:
    # - Works for UNSORTED arrays.
    # - Returns INDICES (LeetCode variant).
    # - Preferred interview solution.
    # ============================================================

    @staticmethod
    def two_sum_hashmap(nums: List[int], target: int) -> List[int]:

        if nums is None or len(nums) < 2:
            return []

        index_by_value = {}

        for index, current_number in enumerate(nums):

            complement = target - current_number

            # REVIEW:
            # Check before inserting to avoid
            # using the same element twice.
            if complement in index_by_value:
                return [index_by_value[complement], index]

            index_by_value[current_number] = index

        return [-1, -1]

    # ============================================================
    # Approach 3 : Two Pointers
    # ============================================================
    # Time  : O(n)
    # Space : O(1)
    #
    # IMPORTANT:
    # Works ONLY for sorted arrays.
    #
    # REVIEW:
    # Returns VALUES instead of indices.
    # Use Hash Map if original indices are required.
    # ============================================================

    @staticmethod
    def two_sum_two_pointer(nums: List[int], target: int) -> List[int]:

        if nums is None or len(nums) < 2:
            return []

        left = 0
        right = len(nums) - 1

        while left < right:

            current_sum = nums[left] + nums[right]

            if current_sum == target:
                return [nums[left], nums[right]]

            # Since the array is sorted,
            # move pointers based on the current sum.
            if current_sum < target:
                left += 1
            else:
                right -= 1

        return [-1, -1]


def main():

    sorted_numbers = [2, 7, 11, 15]
    target = 26

    print("Brute Force :", TwoSum.two_sum_brute(sorted_numbers, target))
    print("Hash Map    :", TwoSum.two_sum_hashmap(sorted_numbers, target))
    print("Two Pointer :", TwoSum.two_sum_two_pointer(sorted_numbers, target))


if __name__ == "__main__":
    main()