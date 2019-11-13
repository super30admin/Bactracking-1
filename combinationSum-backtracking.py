#Accepted on Leetcode
#Time complexity - O(2^N)
#Space complexity - O(N)


class Solution(object):
    def __init__(self):
        self.res = []
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        candidates.sort()
        temp = []
        #index = 0
        if len(candidates) == 0:
            return res
        
        self.backtrack(candidates,target,temp,0)
        return self.res
        
    def backtrack(self,candidates,target,temp,index):
        if index >= len(candidates) or target < 0:
            return
        if target == 0:
            self.res.append(temp[:])
            return
        for i in range(index, len(candidates)):
            if candidates[i] > target:
                break
            temp.append(candidates[i])
            self.backtrack(candidates,target-candidates[i],temp, i)
            temp.pop()