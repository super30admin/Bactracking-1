## Problem1 
# Combination Sum (https://leetcode.com/problems/combination-sum/)

# Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

# The same repeated number may be chosen from candidates unlimited number of times.

# Note:

# All numbers (including target) will be positive integers.
# The solution set must not contain duplicate combinations.
# Example 1:

# Input: candidates = [2,3,6,7], target = 7,
# A solution set is:
# [
#   [7],
#   [2,2,3]
# ]
# Example 2:

# Input: candidates = [2,3,5], target = 8,
# A solution set is:
# [
#   [2,2,2,2],
#   [2,3,3],
#   [3,5]
# ]

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        if candidates == None or len(candidates)==0:
            return self.result 
        self.helper(candidates,target,0,path = [])
        return self.result
    def helper(self,candidates,target,index,path):
        #base
        if index==len(candidates) or target<0:
            return
        if target==0:
            self.result.append(list(path))
            return 
        #logic
        self.helper(candidates, target, index+1, path)
        path.append(candidates[index])
        self.helper(candidates, target-candidates[index],index,path)
        del path[len(path)-1]
         
        #Approach: Backtracking 
        
        