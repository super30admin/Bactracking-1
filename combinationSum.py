"""
Time Complexity : combinationSum() - O(n*2^t) where n is the number of elements in an array and t is target
Space Complexity : combinationSum() - O(1) [O(n*2^t) - stack space]
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : none
"""

class Solution:
    res = []
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if not candidates or len(candidates) == 0:
            return self.res
        self.helper(candidates, target, 0, 0, [])
        return self.res
        
    def helper(self, candidates, target, total, index, temp):
        # base
        if total > target:
            return
        
        if total == target:
            self.res.append(temp.copy())
            return
        
        # recursive
        for i in range(index, len(candidates)):
            temp.append(candidates[i])
            self.helper(candidates, target, total + candidates[i], i, temp)
            temp.pop()