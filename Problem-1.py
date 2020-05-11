"""

## Problem1
Combination Sum (https://leetcode.com/problems/combination-sum/)

Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

"""
def combinationSum(nums, target):
    result=[]
    if nums==None or len(nums)==0:
        return []
    self.helper(nums, 0 , [] , target)
    return result

def helper(self,nums,_sum, temp, index,target):
    #base
    if _sum==target:
        result.append(temp)

    if sum >target or index==len(nums):
        return


    #logic
    #case 1  don't choose a number
    self.helper(nums,_sum, temp, index+1)

    #case 2 choose a number
    temp.add(nums[index])
    self.helper(nums, _sum+nums[index], temp, index + 1)



