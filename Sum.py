# // Time Complexity : Exponential
# // Space Complexity : Exponential
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        result = []
        size = len(candidates)

        def findSum(candidates, index, target, path):
            if target == 0:
                result.append(path[:])
                return
            if target < 0 or index >= size:
                return

            findSum(candidates, index+1, target, path)
            path.append(candidates[index])
            findSum(candidates, index, target - candidates[index], path)
            path.pop()

        findSum(candidates, 0, target, [])
        return result
