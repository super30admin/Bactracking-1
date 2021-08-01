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
            #base
            if target <0 or i==len(candidates):
                return
            if target == 0:
                result.append(list(path))
                return
            #dont choose
            helper(i+1,target,path)
            #choose
            path.append(candidates[i])
            helper(i,target-candidates[i], path)
            path.pop()
        #just index , path
        helper(0,target,[])

        return result