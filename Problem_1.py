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

# Approach - 1
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        """
        Uisng 0-1 recursion
        Time Complexity:O(2^m*k) m = no of nodes; k = amount
        Space Complexity:O(m*H)H: height of the tree
        """
        result = []
        if candidates == None: return result
        
        def helper(candidates, idx, amount, path):
            # Base Condition
            if idx == len(candidates) or amount<0:
                return
            if amount==0:
                
                result.append(path)
                return
            
            # logic
            # we will pass a new path every time we go to the choose/not choose scenario as the path is a data structure list inside stack and it will pass as a refernce so we will get all the elements. To avoid this we will use new list.
            # not choose
            helper(candidates, idx + 1, amount, list(path))
            # choose
            
            
            path.append(candidates[idx])
            
            helper(candidates, idx, amount - candidates[idx], list(path ))
            
        helper(candidates, 0, target, [])
        return result


# Approach - 2
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        """
        When putting choose scenario before not choose 
        Time/ Space Compelexity : same as above
        """
        result = []
        if candidates == None: return result
        
        def helper(candidates, idx, amount, path):
            # Base Condition
            if idx == len(candidates) or amount<0:
                return
            if amount==0:
                
                result.append(path)
                return
            
            # logic
            # we will pass a new path every time we go to the choose/not choose scenario as the path is a data structure list inside stack and it will pass as a refernce so we will get all the elements. To avoid this we will use new list.
            
            
            
             # choose
            # if we will do choose scenario before not choose and add the path above then we will get wrong answer. So to avoid this we will add the path in temp array. We will pass this new temp array in choose scenario only.
            temp = list(path)
            temp.append(candidates[idx])
            
            helper(candidates, idx, amount - candidates[idx], temp)
            # not choose
            helper(candidates, idx + 1, amount, list(path))
           
            
        helper(candidates, 0, target, [])
        return result
            
# Approach -2
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        """
        Time/space: same as above
        """
        result = []
        if candidates == None: return result
        
        def helper(candidates, idx, amount, path):
            # Base Condition
            if idx == len(candidates) or amount<0:
                return
            if amount==0:
                # need to create new array every time as we are adding the same reference.
                result.append(list(path))
                return
            
            # not choose
            helper(candidates, idx + 1, amount, list(path))
            # choose
            
            # Action
            path.append(candidates[idx])
            # Recurse
            helper(candidates, idx, amount - candidates[idx], path)
            #bactrack
            path.pop()
           
            
        helper(candidates, 0, target, [])
        return result

# Approach - 3
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        """
        Brute force for loop based recursion
        Time/space: same as above
        """
        result = []
        if candidates == None: return result
        
        def helper(candidates, pivot, amount, path):
            # Base Condition
            if pivot == len(candidates) or amount<0:
                return
            if amount==0:
                result.append(path)
                return
            
            for i in range(pivot, len(candidates)):
                # we will create depp of copy of the path every time we will iterate
                temp = list(path)
                temp.append(candidates[i])
                helper(candidates, i, amount - candidates[i], temp)
           
            
        helper(candidates, 0, target, [])
        return result

# Apprach - 4

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        """
        force for loop based recursion - bracktracking
        Time/space: same as above
        """
        result = []
        if candidates == None: return result
        
        def helper(candidates, pivot, amount, path):
            # Base Condition
            if pivot == len(candidates) or amount<0:
                return
            if amount==0:
                result.append(list(path))
                return
            
            for i in range(pivot, len(candidates)):
                # Action
                path.append(candidates[i])
                # recurse
                helper(candidates, i, amount - candidates[i], path)
                # Backtrack
                path.pop()
           
            
        helper(candidates, 0, target, [])
        return result
            
           
            
            
            
           
            
            
            
           
            
            
            
                     
            
            