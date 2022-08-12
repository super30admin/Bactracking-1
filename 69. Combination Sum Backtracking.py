# Backtrack using for loop
class Solution:
    result = 0

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        if candidates is None or len(candidates) == 0:
            return self.result

        self.helper(candidates, 0, target, path=[])
        return self.result

    def helper(self, candidates, index, target, path):
        if target == 0:
            self.result.append(path.copy())
            return
        if target < 0:
            return

        for i in range(index, len(candidates)):
            # action
            path.append(candidates[i])
            # recursion
            self.helper(candidates, i, target - candidates[i], path)
            # Backtrack
            path.pop(-1)

# TC =O(2^n).
# Space complexity : O(n). Height of the tree
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No