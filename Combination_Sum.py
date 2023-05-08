# Time Complexity : O(n^target)
# Space Complexity : O(target)

from typing import List
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        def backtrack(start, curr_sum, path):
            if curr_sum == target:
                result.append(path[:])
                return

            if curr_sum > target:
                return

            for i in range(start, len(candidates)):
                path.append(candidates[i])
                backtrack(i, curr_sum + candidates[i], path)
                path.pop()

        result = []
        backtrack(0, 0, [])
        return result