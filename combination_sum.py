#TC==>O(2^n*n)
#SC==> O(n)
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.res=[]
        self.candidates=candidates
        self.dfs([],target,0)
        return self.res
        
    def dfs(self,path,target,index):
            
        if target==0:
            self.res.append(path)
            return
        if target<0:
            return
        for x in range(index,len(self.candidates)):
            self.dfs(path+[self.candidates[x]],target-self.candidates[x],x)