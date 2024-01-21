"""
Time Complexity : O(2^m*n) where m is the length of candidates and n is the target
Space Complexity : O(m+n)  where m is the length of candidates and n is the target

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""


class Solution:
    def __init__(self):
        self.result = []

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if len(candidates) == 0:
            return self.result

        self.helper(candidates, target, 0, [])
        return self.result

    def helper(self, candidates, amount, pivot, path):
        # base case
        if amount == 0:
            self.result.append(path[:])
            return
        if amount < 0:
            return

        # logic
        for i in range(pivot, len(candidates)):
            path.append(candidates[i])
            self.helper(candidates, amount - candidates[i], i, path)
            path.pop()
