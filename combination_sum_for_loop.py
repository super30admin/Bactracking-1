#Time Complexity :  O(exponential))
#Space Complexity : O(exponential)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no

class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        result = []
        def helper(i,target,path):
            if target <0 :
                return
            if target == 0:
                result.append(list(path))
                return
            
            for index in range(i,len(candidates)):
                path.append(candidates[index])
                helper(index,target-candidates[index],path)
                path.pop()

        helper(0,target,[])

        return result