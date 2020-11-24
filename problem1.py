# Time Complexity:- n^n
# Space Complexity:- n+n
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result=[]
        self.tar=target        
        if candidates==[]: return result
        #array templist sum index
        self.backtrack(candidates,[],0,0)
        return self.result
        
        
        
    def backtrack(self,candidates,templist,_sum,index):
            #base condition
            if _sum==self.tar:
                temp2=[]
                temp2=templist[:]
                print(temp2)
                self.result.append(temp2)
                return
            if _sum>self.tar:
                return
            #logic action
            
            for i in range(index,len(candidates)):
                templist.append(candidates[i])
                #print(templist)
                self.backtrack(candidates,templist,_sum+candidates[i],i)
                templist.pop()
                
            
            