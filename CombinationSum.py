# Time Complexity : O(2^N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

# Your code here along with comments explaining your approach
# Backtracking. Base condition is if target < 0 or index == len of list then return
# If the target is 0 append the deepcopy of path to res list
# Else Iterate over the candidates list
# Action is append element at index i to path
# Then recurse by calling the helper function by decreasing the value from target since we chose that element
# The backtrack by popping the element from the list that is go back to previous node or the parent node


class Solution:
    def combinationSum(self, candidates: List[int],
                       target: int) -> List[List[int]]:
        self.res = []
        if not candidates:
            return res
        self.helper(candidates, [], 0, target)
        return self.res

    def helper(self, candidates, path, index, target):
        #base
        if target < 0 or index == len(candidates):
            return
        if target == 0:
            self.res.append(copy.deepcopy(path))
        #logic
        for i in range(index, len(candidates)):
            #action
            path.append(candidates[i])
            #recurse
            self.helper(candidates, path, i, target - candidates[i])

            #backtrack
            path.pop()