from typing import List


class Solution:

    def __init__(self):
        self.result = []

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        """
            https://leetcode.com/problems/combination-sum/
            // Time Complexity : Exponential
            // Space Complexity : Exponential
            // Three line explanation of solution in plain english:
                    - Consider all possible combinations
                        - Add current list value to a temp list
                        - Recursively call for the same value of list as we can reuse the
                          same value
                        - Remove value added at this level as we need to backtrack
        """
        # edge case
        if not candidates or not target: return self.result
        self._backtrack(candidates, target, 0, [], 0)
        return self.result

    def _backtrack(self, candidates: List[int], target: int, sum: int, temp: List[int], index: int):
        # base case
        if sum == target:
            self.result.append(list(temp))
        if sum > target: return
        # logic
        for i in range(index, len(candidates)):
            temp.append(candidates[i])
            self._backtrack(candidates, target, sum + candidates[i], temp, i)
            # backtrack
            temp.pop()
