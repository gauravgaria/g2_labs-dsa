# Two Pointers

## 🎯 Pattern Summary

Two Pointers is an optimization technique that reduces nested loop problems (O(n²)) to a linear scan (O(n)) by intelligently moving two indices.

---

# 🔍 Recognition Clues

Think **Two Pointers** when:

- ✅ Array/String is **sorted**
- ✅ Need to find **pair/triplet**
- ✅ Looking for **target sum**
- ✅ Need to optimize from **O(n²) → O(n)**
- ✅ One pointer movement eliminates part of the search space

---

# 📌 When to Use

- Pair Sum
- Triplet Sum
- Remove Duplicates
- Merge Sorted Arrays
- Reverse Array/String
- Palindrome Checking
- Container problems
- Rain Water problems

---

# ❌ When NOT to Use

- Array is unsorted and sorting is not allowed.
- Original indices must be preserved.
- Problem doesn't exhibit monotonic behavior.

---

# 🧠 Pointer Movement Rules

### Sum < Target

Move **Left Pointer** →

Reason:
Increase the total sum.

---

### Sum > Target

Move **Right Pointer** ←

Reason:
Decrease the total sum.

---

### Sum == Target

Return answer or continue searching depending on the problem.

---

# ⚠️ Common Interview Mistakes

- Forgetting the array must be sorted.
- Returning values instead of indices.
- Incorrect pointer updates.
- Off-by-one errors (`left < right`).
- Infinite loop due to missing pointer movement.

---

# 🚀 Complexity

| Approach | Time | Space |
|----------|------|-------|
| Brute Force | O(n²) | O(1) |
| Two Pointers | O(n) | O(1) |

---

# 💡 Interview Tips

Always clarify:

1. Is the array sorted?
2. Return indices or values?
3. Are duplicate answers allowed?
4. Can I modify the input array?

---

# 📝 Template

```java
int left = 0;
int right = nums.length - 1;

while (left < right) {

    int sum = nums[left] + nums[right];

    if (sum == target) {
        // Found answer
    } else if (sum < target) {
        left++;
    } else {
        right--;
    }
}
```

---

# 🧩 Problems Covered

- ✅ Two Sum
- ⏳ Three Sum
- ⏳ Container With Most Water
- ⏳ Trapping Rain Water
- ⏳ Valid Palindrome
- ⏳ Squares of a Sorted Array
