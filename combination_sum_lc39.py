"""
Name: Srinidhi Bhat
Time Complexity: O(N^(target/min(candidates))) N -no of candidates
Space Complexity: O(target/min(candidates))


Logic: Using backtracking find out all the possibel combinations
as you are exploring do the following - keep reducing target 
as you visit a node. If this becomes negative, this combination is 
not possible.

if the target reaches 0, this combination is possible.
"""
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        res = []
        
        self.dfs(candidates,target,0,[],res)
        return res
        
        
    def dfs(self,nums,target,index,path,res):
        
        if target<0:
            return 
        
        if target == 0:
            res.append(path)
            return
        
        for i in range(index,len(nums)):
            self.dfs(nums,target-nums[i],i,path+[nums[i]],res)