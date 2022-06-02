#Time complexity: exponential
#Space complexity: exponential
class Solution:
    res=[]
    def combinationSum(self, candidates, target: int):
        self.res=[]
        self.helper(candidates,target,0,[])
        return self.res
    
    def helper(self,candidates,target,idx,path):
        if target<0:
            return
        if target==0:
            self.res.append(path.copy())
            return
        for i in range(idx,len(candidates)):
            path.append(candidates[i])
            self.helper(candidates,target-candidates[i],i,path)
            path.pop()
            
        