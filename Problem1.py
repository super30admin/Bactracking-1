# Time Complexity : O(N^T/m+1)
# Space Complexity : O(T/m)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        ans = []
        
        def helper(target, path, index):
            if target == 0:
                ans.append(list(path))
                return
            elif target < 0:
                return
            
            for i in range(index,len(candidates)):
                path.append(candidates[i])
                helper(target-candidates[i], path, i)
                path.pop()
            
        helper(target, [], 0)
        
        return ans
            
                