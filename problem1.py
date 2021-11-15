#Time O(2^n*n), space O(n)
class Solution:
   
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res=[]
        
        self.helper(res,candidates,target,0,[])
        
        return res
    
    
    def helper(self,res,candidates,target,index,cur):
        
        if target == 0:
            res.append(cur.copy())
            return
        
        if target<0:
            return
        
        for i in range(index,len(candidates)):
            cur.append(candidates[i])
            self.helper(res,candidates,target-candidates[i],i,cur)
            cur.pop()
            
            
