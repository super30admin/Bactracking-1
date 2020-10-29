"""
Time - O(N ^ (4))
Space - O(N ^ (4)
Leetcode - Yes
Problems - No
"""
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        self.result =[]
        stack = []
        self.helper(candidates, target, stack, 0)
        return self.result
        
        
    def helper(self,candidates, rsum, stack, start):
        
        if(rsum < 0):
            return
        
        if(rsum == 0):
            self.result.append(list(stack))
            return
        
        for i in range(start, len(candidates)):
            
            #if candidates[i] < target:
            stack.append(candidates[i])
            self.helper(candidates, rsum - candidates[i], stack, i)
            stack.pop()
            