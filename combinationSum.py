# Time Complexity : O(2^N)
# Space Complexity : O(2^N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def __init__(self):
        self.result = []
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if len(candidates)==0: 
            return self.result
        self.helper(sorted(candidates),target,0,0,[])
        return self.result

    def helper(self,candidates,target,currVal,pos,selection):
        if pos == len(candidates):
            return
        # consider curr pos
        selection.append(candidates[pos])

        if currVal + candidates[pos] == target:
            self.result.append(selection.copy())
            return
        elif currVal + candidates[pos] > target:
            return
        else:
            self.helper(candidates,target,currVal+candidates[pos],pos,selection.copy())
        selection.pop()
        self.helper(candidates,target,currVal,pos+1,selection.copy())
