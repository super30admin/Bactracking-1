class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.res=[]
        templist=[]
        candidates.sort()
        self.backtrack(templist,candidates,target,0)
        return self.res
    
    def backtrack(self,templist,candidates,target,start):
        if(target<0):
            return
        
        elif(target ==0):
            self.res.append(templist)
            print("res",self.res)
        
        else:
            for i in range(start,len(candidates)):
                templist.append(candidates[i])
                print(i,templist)
                self.backtrack(templist,candidates,target-candidates[i],i)
                templist.remove(templist[len(templist)-1])
        
        
        
        
        
        
        