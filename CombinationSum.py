"""
// Time Complexity :O(n) Traversing through the candidates.
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NA

//Explanation:
For each candidate,add candidate to itself till sum > target
check with all other candidates till sum > target
if sum == target -> add to result.
"""
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []
        temp = []
        self.backtrack(candidates,target,0,0,result,temp)
        return result

    def backtrack(self,candidates,target,index,sum,result,temp):
        # base case
        if sum > target:
            return

        if sum == target:
            result.append(list(temp))
            return


        # logic
        for i in range(index,len(candidates)):
            #action
            temp.append(candidates[i])
            #recursion
            self.backtrack(candidates,target,i,sum+candidates[i],result,temp)
            #backtrack
            temp.pop(-1)
