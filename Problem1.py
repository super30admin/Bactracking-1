# Time Complexity : O(2**N)
# Space Complexity : O(2**N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


#FINDING ALL THE POSSIBLE SOLUTIONS 
class Solution:
    def __init__(self):
        self.out = []
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.helper(sorted(candidates),target,0,0,[])
        return self.out
    
    def helper(self,candidates,t,currVal,pos,selection):
        if pos == len(candidates):
            return;
        # consider curr pos
        selection.append(candidates[pos])
        
        if currVal + candidates[pos] == t:
            self.out.append(selection.copy())
            return;
        elif currVal + candidates[pos] > t:
            return;
        else:
            self.helper(candidates,t,currVal+candidates[pos],pos,selection.copy())
        selection.pop()
        self.helper(candidates,t,currVal,pos+1,selection.copy())
        
