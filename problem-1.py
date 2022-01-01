class Solution:
    def helper(self,candidates,temp,i,localSum):
        if (i==len(candidates) or localSum>self.target):
                return
        if(localSum==self.target):
            self.result.append(temp.copy())
            return
        
        temp.append(candidates[i])
        self.helper(candidates,temp,i,localSum+candidates[i])
        
        temp.pop()
        self.helper(candidates,temp,i+1,localSum)
        
        
        
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.target = target
        self.result = []
        
        if candidates==None or len(candidates)==0:
            return self.target
        
        self.helper(candidates,[],0,0)
        return self.result
            
        
        
        