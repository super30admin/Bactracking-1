"""
Time Complexity : O(N^T) where N is candidates and T is target
Space Complexity : O(N^T) where N is candidates and T is target
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        if len(candidates) == 0:
            return self.result
        self.backtrack(candidates, target, 0, [])
        return self.result
    def backtrack(self, candidates, target, index, path: List[int]):
        # Base
        if target == 0:
            self.result.append(list(path))
            return
        if target < 0:
            return
        # Loop through the candidates at aparticular index and backtrack
        for i in range(index,len(candidates)):
            # Action
            path.append(candidates[i])
            # Recursion
            self.backtrack(candidates, target - candidates[i], i, path)
            # Backtrack
            path.remove(candidates[i])