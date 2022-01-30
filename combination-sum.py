'''
TC: O(2^(m+n))
SC: O(m + n) - take mins, and do not rest

Intuition: backtracking
'''
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = list()
        
        self.helper(0, candidates, target, [], res)
        return res
        
    def helper(self, start, nums, target, combs, res):
        if target == 0:
            res.append(combs)
            return
        if target < 0:
            return
        for i in range(start, len(nums)):
            self.helper(i, nums, target - nums[i], combs + [nums[i]], res)
        
            
        