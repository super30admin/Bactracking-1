# TC : O(2^N) - worse case
# SC : O(2^(Target//min of candidates))
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        
        def recur(candidates, index, path, target):
            from copy import deepcopy
            # BASE
    
            if index>=len(candidates) or target <0:
                return
            if target == 0:
                res.append(path) # so that reference does not get copied
                return 
            # LOGIC 
            # not choose
            # recur
            recur(candidates, index + 1, deepcopy(path), target)
            # choose
            # recur
            path.append(candidates[index])
            recur(candidates, index, deepcopy(path), target-candidates[index])
            # remove element
            #_ = path.pop() # for backtrack same ref of path is shared 
        
        recur(candidates, 0, [], target)
        return res
