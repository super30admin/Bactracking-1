# Time Complexity : O( (N * (T/min(N)) ) where T is target, N is number of candidates
# Space Complexity : O(N) where N is number of candidates
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def __init__(self):
        self.result = []
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.sumHelper(candidates, target, [], 0)
        return self.result
    
    def sumHelper(self, candidates, target, path, pivot):
        #base
        if target == 0:
            self.result.append(path[:])
            #self.result.append(list(path))
            #self.result.append(copy.deepcopy(path))
            return
        if target < 0:
            return
        
        for i in range(pivot, len(candidates)):
            #action
            path.append(candidates[i])
            #recurse
            self.sumHelper(candidates, target - candidates[i], path, i)
            #backtrack
            path.pop()