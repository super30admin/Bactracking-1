# 39. Combination Sum
# https://leetcode.com/problems/combination-sum/


# Brute Force Recursive Solution
# Time Complexity = O(2^n)
# Space Complexity = O(n)

class Solution(object):
    result =[]
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        if not candidates:
            return []
        self.result = []

        def helper(candidates, index, target, arr_list):
            # base case
            if index==len(candidates) or target<0:
                return
            
            if target==0:
                
                self.result.append(arr_list)
                return
            
            # logic
            helper(candidates, index+1, target, arr_list)
            new_li = list(arr_list)
            new_li.append(candidates[index])
            helper(candidates, index, target - candidates[index], new_li)
            
        
        
        helper(candidates, 0, target, [])
        return self.result


#  Backtracking
class Solution(object):
    result =[]
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        if not candidates:
            return []
        self.result = []

        def helper(candidates, index, target, arr_list):
            
            # base case
            if index==len(candidates) or target<0:
                return
            
            if target==0:
                self.result.append(list(arr_list))
                return
            
            # logic
            arr_list.append(candidates[index])
            helper(candidates, index, target - candidates[index], arr_list)
            
            arr_list.pop()
            helper(candidates, index+1, target, arr_list)
            
        
        
        helper(candidates, 0, target, [])
        return self.result


# using for loop
# Time Complexity = O(2^T/min(candidates))
# Space Complexity = O(T/min(candidates))
class Solution(object):
    result = []
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        
        self.result = []
        def helper(candidates, index, target, arr_list):
            if index==len(candidates) or target<0:
                return
            
            if target==0:
                self.result.append(list(arr_list))
                return
            
            for i in range(index, len(candidates)):
                # action
                arr_list.append(candidates[i])
                
                # recursive
                helper(candidates, i, target-candidates[i], arr_list)
                arr_list.pop()
        
        helper(candidates, 0, target, [])
        return self.result