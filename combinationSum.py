"""" Recusion Approach """

#Accepted on Leetcode
#Time complexity - O(N)
#Space complexity - O(N) 

class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        candidates.sort()
        res = set()
        intermediate = []
        self.recursion(candidates,target,res,intermediate)
        return [list(i) for i in res]
    
    def recursion(self,candidates,target,res,intermediate):
        for i in candidates:
            if target == i:
                temp=intermediate + [i]
                temp.sort()
                if temp is not None:
                    res.add(tuple(temp))
                return
            elif target > i:
                self.recursion(candidates,target-i,res,intermediate+[i])
            else:
                return