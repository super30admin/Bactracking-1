# Time Complexity :O(2^n)
# Space Complexity :O(2^n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution(object):
    def backtrack(self,candidates,temp,target,res):
        # if reached the target append anser and return
        if target ==0:
            res.append(temp)
            return
        # if no candidates or target is -ve return
        elif not candidates or target < 0:
            return
        else:
            #loop through the array and recurse using backtracking appending inside the function call returns a clone of array
            for i in range(len(candidates)):
                # if it will become negative break
                if candidates[i] > target:
                    break
                self.backtrack(candidates[i:],temp+[candidates[i]],target-candidates[i],res)
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        #sort candidates
        candidates.sort()
        res = []
        #backtrack and return
        self.backtrack(candidates,[],target,res)
        return res