"""
===============================================================
Problem      : Rearrange 0s and 1s
Pattern      : Two Pointers (Partitioning)

Time Complexity : O(n)
Space Complexity: O(1)

Interview Tips
------------------------------------------------
• Partition the array into two regions.
• Move pointers independently.
• Swap only when both pointers are incorrect.
===============================================================
"""


class RearrangeZeroAndOne:

    @staticmethod
    def partition_zero_and_one(binary_array):

        if binary_array is None or len(binary_array) < 2:
            return binary_array

        left = 0
        right = len(binary_array) - 1

        while left < right:

            # Left element already belongs to left partition.
            if binary_array[left] == 0:
                left += 1

            # Right element already belongs to right partition.
            elif binary_array[right] == 1:
                right -= 1

            # Both elements are misplaced.
            else:
                binary_array[left], binary_array[right] = (
                    binary_array[right],
                    binary_array[left],
                )

                left += 1
                right -= 1

        return binary_array


if __name__ == "__main__":

    binary_array = [1, 1, 0, 1, 0, 1, 0, 1, 0]

    print(RearrangeZeroAndOne.partition_zero_and_one(binary_array))