#Time Complexity : O(2^t) where t is the target value
#Space Complexity :O(1)
#Did this code successfully run on Leetcode :Yes
#Any problem you faced while coding this :No

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        
        res = []
        
        def dfs(i, curr, currSum):
            if currSum == target:
                res.append(curr.copy())
                return
            if i>= len(candidates) or currSum> target:
                return 
            
            curr.append(candidates[i])
            
            dfs(i, curr, currSum+candidates[i]) 
            curr.pop()
            
            dfs(i+1, curr, currSum) 
            
        dfs(0,[],0)
        return res
