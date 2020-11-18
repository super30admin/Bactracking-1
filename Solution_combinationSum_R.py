mport copy 
class Solution_combinationSum_R:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.res=[]
        templist=[]
        if candidates is None or len(candidates)==0:
            return self.res
        self.helper(candidates,target,templist,0,0)
        return self.res
    
    def helper(self,candidates,target,templist,sum1,i):
        if (sum1>target or i>=len(candidates)):
            return 
        if(sum1==target):
            self.res.append(templist)
            return
        #logic
      
        self.helper(candidates,target,templist,sum1,i+1) #dontchoose
        temp1=copy.deepcopy(templist)
        temp1.append(candidates[i])
        self.helper(candidates,target,temp1,sum1+candidates[i],i)#choose
        
        
        
        
        
        
        
        
        
        
     