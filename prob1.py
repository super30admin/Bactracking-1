# Time Complexity => O(2^N)
# Space Complexity => O(N)

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if (len(candidates) == 0):
            return 0
        targetsum = target
        self.result = []
        self.helper(candidates,targetsum,0,[])
        
        return self.result
    
    
    def helper(self,candidates,targetsum,index,path):
        if(targetsum < 0):
            return
        if(targetsum == 0):
            self.result.append(path.copy())
        
        for i in range(index,len(candidates)):
            path.append(candidates[i])
            self.helper(candidates,targetsum-candidates[i],i,path)
            path.pop(len(path)-1)        