#Time complexity: O(2^(Target/minNum))
#space complexity: O(Target/minNum)
class Solution:
    def __init__(self):
        self.res = []
        
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        self.helper(candidates, target, 0, [])
        return self.res
    
    def helper(self, candidates, target, idx, path):
        #base
        if target == 0:
            self.res.append(path.copy())
            return
        if target < 0:
            return
        
        #logic
        for i in range(idx, len(candidates)):
            path.append(candidates[i])
            self.helper(candidates, target-candidates[i], i, path)
            del path[-1]
            
        
        
