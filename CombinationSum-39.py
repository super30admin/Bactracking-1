# Time Complexity : O(n^n)
# Space Complexity : O(n)  element added to curr
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#add a candidate and check for target if not remove it
#[2,2,2,2] -> [2,2,2,3] -> [2,2,2,6] -> [2,2,2] (remove)
class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        res = []
        def backtrack(curr, idx ,target):
            if target == 0:
                res.append(list(curr))
            elif target < 0:
                return
            for i in range(idx, len(candidates)):
                curr.append(candidates[i])
                backtrack(curr, i, target - candidates[i])
                curr.remove(candidates[i])

        backtrack([], 0, target)
        return res
