"""
Time complexity is 0(N^M)
Space complexity is O(M) ...maximum depth till you get to target


"""


import copy
class Solution_combinationSum_BK:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.res=[]
        templist=[]
        if candidates is None or len(candidates)==0:
            return self.res
        self.backtrack(candidates,target,templist,0,0)
        return self.res
    
    def backtrack(self,candidates,target,templist,sum1,pivot):
        if (sum1>target):
            return 
        if(sum1==target):
            temp1=copy.deepcopy(templist)
            self.res.append(temp1)
            return
        #logic
        for i in range(pivot,len(candidates)):
            #action
            templist.append(candidates[i])
            #recurse
            self.backtrack(candidates,target,templist,sum1+candidates[i],i)
            #backtrack
            templist.pop()
        
        
        
        
        
        
        
        
        
     