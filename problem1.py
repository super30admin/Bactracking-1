# https://leetcode.com/problems/combination-sum

# Time Complexity : O(2^N)
# Space Complexity : O(N) where N is the length of the element
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, missed one base condition. Added it later.


# Your code here along with comments explaining your approach

# Approach : We use 0,1 recursion and backtracking approach where we either pick an element or skip it whenever we pick
# an element we reduce the target by cur element and do not move the index forward, as we can have multiple elements
# If we don't pick an element we move forward. If we reach target == 0 we add the list to result

from typing import List


class Solution:
    result: []

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        self.backtrack(candidates, 0, target, [])
        return self.result

    def backtrack(self, candidates, index, target, cur_result):
        if target == 0:
            self.result.append(cur_result.copy())
            return
        if index == len(candidates) or target < 0:
            return

        # NO TAKE
        self.backtrack(candidates, index + 1, target, cur_result)

        # TAKE
        cur_result.append(candidates[index])

        self.backtrack(candidates, index, target - candidates[index], cur_result)

        cur_result.pop()