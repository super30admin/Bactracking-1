# Have coded all possible solution - Recursion, Backtracking,  Recursion with for loop, Backtracking with for loop and changing order of choose and not choose
# Did this code successfully run on Leetcode(All solution provided here) : Yes
# Any problem you faced while coding this : No

# Time - Exponential O(2^n) for both the cases
# Space - Exponential  O(n x 2^n) for recursion and O(n) for Backtracking

# Approach- 1
# Recursion

# Normal Recursion
class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        self.result = []
        if not candidates or len(candidates) == 0:
            return self.result
        self.helper(candidates, 0, [], target)
        return self.result
    
    def helper(self, candidates, index, path, target):
        #base 
        if index == len(candidates) or target < 0:
            return
        
        if target == 0:
            self.result.append(path)
            return 
        
        #logic
        #don't case
        self.helper(candidates, index + 1, list(path), target)
        
        #choose case
        path.append(candidates[index])
        self.helper(candidates, index, list(path), target - candidates[index])


# Approach- 2
# Backtracking

# Backtacking Faster than Recursion
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        if not candidates or len(candidates) == 0:
            return self.result
        self.helper(candidates, 0, [], target)
        return self.result
    
    def helper(self, candidates, index, path, target):
        #base (if I don't use RecursionError: maximum recursion depth exceeded in comparison)
        if index == len(candidates) or target < 0:
            return
        
        if target == 0:
            self.result.append(path.copy())
            return 
        
        #logic
        #don't case
        self.helper(candidates, index + 1, path, target)
        
        #choose case
        #action
        path.append(candidates[index])
        #Recurse
        self.helper(candidates, index, path, target - candidates[index])
        
        # backtrack
        path.pop()
    
# Approach - 3
# Recursion with for loop

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        if not candidates or len(candidates) == 0:
            return self.result
        self.helper(candidates, 0, [], target)
        return self.result
    
    def helper(self, candidates, index, path, target):
        #base (if I don't use RecursionError: maximum recursion depth exceeded in comparison)
        if index == len(candidates) or target < 0:
            return
        
        if target == 0:
            self.result.append(path)
            return 
        
        #logic
        for i in range(index, len(candidates)):
            #don't choose
            temp = list(path)
            
            #choose
            #action
            temp.append(candidates[i])
            #recurse
            # not index it's i since it's moving ahead
            self.helper(candidates, i, temp, target - candidates[i])
            
            
 #Approach - 4
 # Backtacking with for loop
 
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        if not candidates or len(candidates) == 0:
            return self.result
        self.helper(candidates, 0, [], target)
        return self.result
    
    def helper(self, candidates, index, path, target):
        #base (if I don't use RecursionError: maximum recursion depth exceeded in comparison)
        if index == len(candidates) or target < 0:
            return
        
        if target == 0:
            self.result.append(path.copy())
            return 
        
        #logic
        for i in range(index, len(candidates)):
            #action
            path.append(candidates[i])
            #recurse
            # not index it's i since it's moving ahead
            self.helper(candidates, i, path, target - candidates[i])
            #backtrack
            path.pop()
            
# Approach - 5
#Backtracking with for loop using temp

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        if not candidates or len(candidates) == 0:
            return self.result
        self.helper(candidates, 0, [], target)
        return self.result
    
    def helper(self, candidates, index, path, target):
        #base (if I don't use RecursionError: maximum recursion depth exceeded in comparison)
        if index == len(candidates) or target < 0:
            return
        
        if target == 0:
            self.result.append(path.copy())
            return 
        
        #logic
        for i in range(index, len(candidates)):
            #don't choose
            temp = list(path)
            
            #choose
            #action
            temp.append(candidates[i])
            #recurse
            # not index it's i since it's moving ahead
            self.helper(candidates, i, temp, target - candidates[i])
            #backtrack 
            temp.pop()
            
#Approach - 6
#changing order of choose and not choose

class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        self.result = []
        if not candidates or len(candidates) == 0:
            return self.result
        self.helper(candidates, 0, [], target)
        return self.result
    
    def helper(self, candidates, index, path, target):
        #base 
        if index == len(candidates) or target < 0:
            return
        
        if target == 0:
            self.result.append(path)
            return 
        
        #logic
        temp = list(path)
        temp.append(candidates[index])
        #choose case
        self.helper(candidates, index, temp, target - candidates[index])
        #don't case
        self.helper(candidates, index + 1, list(path), target)

        
