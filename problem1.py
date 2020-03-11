'''
Time Complexity: O(2^n)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation: Create a complete space of all possible combinations and backtract whenever you overshoot the target.
'''
import copy


class Solution:
    def backtrack(self, solution: List[int], candidates: List[int], state: List[int], target: int, sum1: int,
                  index: int):
        if sum1 > target:
            return
        if sum1 == target:
            solution.append(copy.deepcopy(state))
            return

        for i in range(index, len(candidates)):
            state.append(candidates[i])
            self.backtrack(solution, candidates, state, target, sum1 + candidates[i], i)
            # pops elements and adds combination, last pop will be an empty array and start with a new subtree
            state.pop()

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        # solution
        solution = []
        # state
        state = []
        self.backtrack(solution, candidates, state, target, 0, 0)

        return solution