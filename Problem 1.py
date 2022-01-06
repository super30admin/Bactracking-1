# Time: Exponential
# Space: Exponential
class Solution(object):
    def __init__(self):
        self.ans = []
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        self.helper(0, 0, candidates, target, [])
        return self.ans
    def helper(self, sm, index, candidates, target, curr):
        if index == len(candidates):
            return
        if sm == target:
            self.ans.append(list(curr))
        if sm > target:
            return
        for i in range(index, len(candidates)):
            curr.append(candidates[i])
            self.helper(sm+candidates[i], i, candidates, target,curr)
            curr.pop()
            
        
        
        
        
