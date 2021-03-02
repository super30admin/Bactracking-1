# Combination Sum

# Time Complexity : Exponential or N^M where N is length of candidates and M is target
# Space Complexity : O(N+M) N is length of candidates and M is the target
# Did this code successfully run on Leetcode : Yes with Runtime 108 ms and Memory 14.4 MB 
# Any problem you faced while coding this : Initally yes, After class understanding no.
# Your code here along with comments explaining your approach
# Approach
"""
Recursion is not the optimal solution due to increase in space complexity(mainitaining seperate list) 
is exponential. The optimal solution to this problem is Backtracking. It involves Action, Recursion 
and Backtracking.temp is initialized as empty list which gets appended to the result when the 
function is called Similarly index and cursum are initialized to 0. It is choosing or not choosing
if chossing go to next index i.e i+1.

"""
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = [] # output list to be returned
        if(candidates==None) or len(candidates)==0: # Base cases
            return result
        def backtrack(index, cursum, temp):
            if cursum == target:
                result.append(temp)
                return
            if cursum > target:
                return
            i = index
            while i < len(candidates):
                backtrack(i, cursum + candidates[i], temp + [candidates[i]])
                while i + 1 < len(candidates) and candidates[i + 1] == candidates[i]:
                    i += 1
                i += 1
        backtrack(0, 0, [])
        return result