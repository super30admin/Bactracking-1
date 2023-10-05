# Time Complexity: O(2^n) where n is the length of the array
# Space Complexity:  O(n)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        self.helper(candidates, 0, [], target)
        return self.result

    def helper(self, candidates, index, path, remainingTarget):
        #base
        if remainingTarget == 0:
            self.result.append(path.copy())
            return
        if index >= len(candidates) or remainingTarget < 0:
            return

        #action
        #not choose
        self.helper(candidates, index +1, path, remainingTarget)
        #choose
        path.append(candidates[index])
        self.helper(candidates, index, path, remainingTarget - candidates[index])
        path.pop()
##################################################################
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        self.helper(candidates, 0, [], target)
        return self.result

    def helper(self, candidates, index, path, remainingTarget):
        if remainingTarget == 0:
            self.result.append(path.copy())
            return
        if remainingTarget < 0:
            return

        for i in range(index, len(candidates)):
            path.append(candidates[i])
            self.helper(candidates, i, path, remainingTarget - candidates[i])
            path.pop()
