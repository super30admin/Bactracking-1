# Time Complexity : O(N!) NOT SURE JUST COUNTING THE COMBINATIONS
# Space Complexity : O(N!) NOT SURE
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

class Solution:
    def __init__(self):
        self.result = []
        
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        self.helper(candidates, target, 0, [])
        return self.result
        
    def helper(self, candidates, target, index, state):
        if target<0:
            return
        if target==0:
            res = []
            for x in state:
               res.append(x) 
            self.result.append(res)
        
        while(target>0 and index<len(candidates)):
            
            state.append(candidates[index])
            self.helper(candidates, target-candidates[index], index, state)
            index +=1
            state.pop()
            
        
        
        