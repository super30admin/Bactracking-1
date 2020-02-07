# Time Complexity : Expnential
# Space Complexity : Recusrive Stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : -

class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        
        self.retList = []
        if candidates is None or len(candidates) == 0:
            return self.retList
        self.__helper(candidates, target, 0, target, [])
        return self.retList
    
    
    def __helper(self, candidates, target, index, remainingSum, tempList):
        # Base Case
        # print(candidates, target, index, remainingSum, tempList)
        if remainingSum < 0:
            return
        if remainingSum == 0:
            self.retList.append(tempList[:])
        
        # Logic
        for i in range(index, len(candidates)):
            tempList.append(candidates[i])
            self.__helper(candidates, target, i, remainingSum-candidates[i], tempList)
            tempList.pop()