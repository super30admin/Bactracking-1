import copy
class Solution:
    def __init__(self):
        self.result=[]
        self.target=None
    
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.target=target
        self.backtrack(candidates,[],0,0)
        return self.result
    #the temp array is temporary and is passed by refercen
    #need to take a copy when base case hits
    def backtrack(self,candidates,temp,sum1,index):
        if sum1>self.target:
            return
        if sum1==self.target:
            self.result.append(copy.copy(temp))
        for i in range(index,len(candidates)):
            temp.append(candidates[i])
            self.backtrack(candidates,temp,sum1+candidates[i],i)
            temp.pop()
        
 Time Complexity is O(2 raise to power n)
Space Complexity is O(n) as one global self.result is create but I am returing it as well, so will space be O(1)
