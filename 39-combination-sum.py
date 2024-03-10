
"""
39. Combination Sum
Medium
"""
from leetcode_runner import LeetCode, TestCase, Args
from typing import *

PROBLEM = """
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 
Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:

Input: candidates = [2], target = 1
Output: []

 
Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40


"""

class Solution:
    """
    Accepted
    
    Time Complexity: O(2^n)
    Space Complexity: O(n)
    
    Approach:
    - Use backtracking to find all unique combinations of candidates that sum up to the target.
    - Start with an empty current combination and a total sum of 0.
    - Iterate through the candidates array:
        - If the total sum exceeds the target or we have reached the end of the candidates array, return.
        - If the total sum equals the target, add the current combination to the result.
        - Add the current candidate to the current combination and recursively call the function with the same index and an updated total sum.
        - Remove the last added candidate from the current combination and recursively call the function with the next index and the same total sum.
    - Return the result, which contains all unique combinations that sum up to the target.
    """
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        def dfs(i, curr, total):
            print(curr)
            if total > target or i >= len(candidates):
                return
            if total == target:
                res.append(curr.copy())
                return
            curr.append(candidates[i])
            dfs(i, curr, total + candidates[i]) 
            curr.pop()
            dfs(i + 1, curr, total)
        dfs(0,[],0)
        return res

LeetCode(PROBLEM, Solution).check()
