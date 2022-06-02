#Time Complexity: Exponential
#Space Complexity: Exponential
class Solution:
    result = []
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        self.helper(candidates,target,0,[])
        return self.result
    
    
        
    def helper(self,candidates,target,idx,path):
        if target == 0:
            self.result.append(path.copy())
            
        if target < 0:
            return 
        
        for i in range(idx,len(candidates)):
            path.append(candidates[i])
            self.helper(candidates,target-candidates[i],i,path)
            path.pop()
            
            
            