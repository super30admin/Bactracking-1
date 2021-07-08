# Backtracking solution
class Solution:
    # Declare a global list to return the result
    def __init__(self):
        self.result = []
    
    # To make the recursive calls, declare a helper function
    def helper(self, candidates, target, index, path):
        # Base case 
        # 1. When target is zero
        # 2. When the index is equal to len of candidates or target is less than 0
        if target == 0:
            return self.result.append(copy.copy(path))
        if target < 0 or index == len(candidates):
            return
        # Logic
        # Not choose
        # Create a copy of path at each call because it is a different path
        self.helper(candidates, target, index + 1, path)
        # choose
        # Append the element in the candidates to path and recursive call
        # action
        path.append(candidates[index])
        # recurse
        self.helper(candidates, target - candidates[index], index, path)
        # backtrack
        path.pop()
        
        
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        # Null condition check
        if candidates == None or len(candidates) == 0:
            return result
        # Call the recursive helper function
        self.helper(candidates, target, 0, [])
        # Return the global variable which stores the result
        return self.result






# Recursion solution
class Solution:
    # Declare a global list to return the result
    def __init__(self):
        self.result = []
    
    # To make the recursive calls, declare a helper function
    def helper(self, candidates, target, index, path):
        # Base case 
        # 1. When target is zero
        # 2. When the index is equal to len of candidates or target is less than 0
        if target == 0:
            return self.result.append(path)
        if target < 0 or index == len(candidates):
            return
        # Logic
        # Not choose
        # Create a copy of path at each call because it is a different path
        self.helper(candidates, target, index + 1, copy.copy(path))
        # choose
        # Append the element in the candidates to path and recursive call
        path.append(candidates[index])
        self.helper(candidates, target - candidates[index], index, copy.copy(path))
        
        
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        # Null condition check
        if candidates == None or len(candidates) == 0:
            return result
        # Call the recursive helper function
        self.helper(candidates, target, 0, [])
        # Return the global variable which stores the result
        return self.result





# Choose case first in Recursion solution
class Solution:
    # Declare a global list to return the result
    def __init__(self):
        self.result = []
    
    # To make the recursive calls, declare a helper function
    def helper(self, candidates, target, index, path):
        # Base case 
        # 1. When target is zero
        # 2. When the index is equal to len of candidates or target is less than 0
        if target == 0:
            return self.result.append(path)
        if target < 0 or index == len(candidates):
            return
        # Logic
        # choose
        # If we choose the element first, make a copy of path because path will be modified and we dont want to use the same path for not choose case also.
        # Append the element in the candidates to path and recursive call
        path_copy = copy.copy(path)
        path_copy.append(candidates[index])
        self.helper(candidates, target - candidates[index], index, copy.copy(path_copy))
        # Not choose
        # Create a copy of path at each call because it is a different path
        self.helper(candidates, target, index + 1, copy.copy(path))
        
        
        
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        # Null condition check
        if candidates == None or len(candidates) == 0:
            return result
        # Call the recursive helper function
        self.helper(candidates, target, 0, [])
        # Return the global variable which stores the result
        return self.result