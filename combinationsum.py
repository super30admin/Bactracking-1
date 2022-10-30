##Time Complexity : 2^m/2  ~2^m
##Space Complexity : O(n)
##Did this code successfully run on Leetcode : Yes
class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        self.result = []
        candidates.sort()
        if not candidates:
            return []
            
        self.helper(candidates, 0, [], target)
        return self.result
        
    
    def helper(self, candidates, start, items, target):
        
        if target == 0:
            self.result.append(items)

        for i in range(start,len(candidates)):
            if candidates[i]>target:
                return
            self.helper(candidates, i, items+[candidates[i]], target-candidates[i])
        