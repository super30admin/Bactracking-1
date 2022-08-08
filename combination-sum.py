"""
Runtime Complexity- Exponential
Space Complexity: we create new list for every path and this can be saved by using backtracking because we would create a new list only 
when we hit the base case.
"""
#Normal recursion - choos or not choose solution
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if not candidates:
            return [[]]
        self.result = []
        self.helper(candidates, target, 0  ,[])
        return self.result
    
    def helper(self, candidates, target , index , path):
        if target<0 or index == len(candidates):
            return 
        if target == 0:
            self.result.append(path)
            return
        #0 case or do not choose case
        self.helper(candidates,target,index+1,path.copy())
        #1 case or choose case
        path.append(candidates[index])
        self.helper(candidates,target-candidates[index],index,path.copy())
        

# recursion using backtracking

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if not candidates:
            return [[]]
        self.result = []
        self.helper(candidates, target, 0  ,[])
        return self.result
    
    def helper(self, candidates, target , index , path):
        if target<0 or index == len(candidates):
            return 
        if target == 0:
            self.result.append(path.copy())
            return
        #0 case or do not choose case
        self.helper(candidates,target,index+1,path)
        #1 case or choose case
        path.append(candidates[index])
        self.helper(candidates,target-candidates[index],index,path)
        #backtrack
        size = len(path)
        path.pop(size-1)
        
        
        
        
        