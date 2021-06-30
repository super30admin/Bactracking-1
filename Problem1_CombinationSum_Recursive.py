'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 39. Combination Sum

# Given an array of distinct integers candidates and a target integer target, 
# return a list of all unique combinations of candidates where the chosen numbers 
# sum to target. You may return the combinations in any order.

# The same number may be chosen from candidates an unlimited number of times. 
# Two combinations are unique if the frequency of at least one of the chosen numbers 
# is different.

# It is guaranteed that the number of unique combinations that sum up to target is 
# less than 150 combinations for the given input.

    

#-----------------
# Time Complexity: 
#-----------------
# O(2^N) - Exponential because at every step of the recursion there is a binary
#        - choice until target becomes = 0. Can go upto 2^N combinations with
#        - N unique nummbers
#------------------
# Space Complexity: 
#------------------
# O(target): Maximum length of the path list can be equal to the target sum
#            in worst case, considering number 0. N is the length of the
#            combinations array.


#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        if len(candidates) == 0:
            return result
        self.helper(candidates, target, 0, [])
        return self.result
    
    def helper(self, candidates, target, i, path):
        # base
        if target < 0 or i==len(candidates):
            return
        
        if target == 0:
            self.result.append(path)
            return
        
        # logic
        
        # case 1 choose
        self.helper(candidates,target, i+1, list(path))
        # case 2 not choose
        path.append(candidates[i])
        self.helper(candidates, target-candidates[i], i, list(path))