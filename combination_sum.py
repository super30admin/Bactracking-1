class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.res=[]
        self.backtrack(candidates,target,0,0,[])
        return self.res       
        
    def backtrack(self,candidates,target,sum1,index,templist):
        if(sum1==target):
            self.res.append(list(templist))
            return
        if(sum1>target):
            return
        for i in range(index,len(candidates)):
            templist.append(candidates[i])
            self.backtrack(candidates,target,sum1+candidates[i],i,templist)
            templist.pop(-1)
            
