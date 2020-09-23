# Time Complexity : O(N^N)
# Space Complexity : O(m), m is the max. number of elements that can be added to path until it exceeds target
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

class Solution:
    
    def __init__(self):
        self.output = []
    
    
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        path = []
        self.backTracking(candidates, target, 0 , path)
        
        return self.output
    
    def backTracking(self, candidates, target, index, path):
        
        if target < 0:
            return
        elif target == 0:
            self.output.append(list(path))
            return
        elif index >= len(candidates):
            return
        
        for i in range(index, len(candidates)):
            
            #add to current path
            path.append(candidates[i])
            
            #recursive calls
            self.backTracking(candidates, target-candidates[i], i, path)
            
            #delete from current path
            path.pop(len(path)-1)