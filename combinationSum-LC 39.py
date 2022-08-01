# Time Complexity = exponential

# For Loop based Recursion with backtracking
class Solution:
    def combinationSum(self, candidates: list[int], target: int) -> list[list[int]]:
        if candidates == None:
            return [[]]
        
        self.result = []
        
        self.helper(candidates, target, 0, [])
        
        return self.result
    
    
    def helper(self, candidates, target, index, path):
        # Base Case
        if target < 0:
            return
        if target == 0:
            self.result.append(path.copy())
        
        
        size = len(candidates)
        
        
        # Logic
        # i iterates over all the remaining elements(elements ahead of index), at a particular index. 
        for i in range(index, size):
            
            # Action 
            path.append(candidates[i])
            
            # Recursion
            self.helper(candidates, target - candidates[i], i, path)
            
            # Backtrack
            path.pop(len(path) - 1)
            


            

# For Loop based Recursion 
class Solution:
    def combinationSum(self, candidates: list[int], target: int) -> list[list[int]]:
        if candidates == None:
            return [[]]
        
        self.result = []
        
        self.helper(candidates, target, 0, [])
        
        return self.result
    
    
    def helper(self, candidates, target, index, path):
        # Base Case
        if target < 0:
            return
        if target == 0:
            self.result.append(path)
        
        
        size = len(candidates)
        
        
        # Logic
        for i in range(index, size):
            
            new = path.copy()
            
            # Action 
            new.append(candidates[i])
            
            # Recursion
            self.helper(candidates, target - candidates[i], i, new)
            
            # Backtrack
            #path.pop(len(path) - 1)



# Backtracking solution
# Saves space and time
class Solution:
    def combinationSum(self, candidates: list[int], target: int) -> list[list[int]]:
        if candidates == None:
            return [[]]
        
        self.result = []
        
        self.helper(candidates, target, 0, [])
        
        return self.result
    
    
    def helper(self, candidates, target, index, path):
        # Base Case
        if target < 0 or index == len(candidates):
            return
        if target == 0:
            # Only when target sum is zero, copy the contents of the path to the result list
            self.result.append(path.copy())
            return                     # To stop unnecessary traversal and addition of the same path
        
        # Logic
        # 0 case or do notmchoose case
        self.helper(candidates, target, index + 1, path)
        
        # 1 case or choose case
        # Action
        path.append(candidates[index])
        
        # Recursion
        # Index is same coz a number can be picked unlimited times
        # Only one path reference as we are doing. backtracking, so path will only store the relevant values/ans
        self.helper(candidates, target - candidates[index], index, path)
        
        # Backtrack
        size = len(path)
        path.pop(size - 1)          # Removing the last element, during backtracking
        


        
# Choose / Not Choose solution (like done in coin change) - Normal Recursion
# But here, more time (copying to new lists) and more space (different lists) are being used
class Solution:
    def combinationSum(self, candidates: list[int], target: int) -> list[list[int]]:
        if candidates == None:
            return [[]]
        
        self.result = []
        
        self.helper(candidates, target, 0, [])
        
        return self.result
    
    
    def helper(self, candidates, target, index, path):
        # Base Case
        if target < 0 or index == len(candidates):
            return
        if target == 0:
            # Since different path copies are passed in both cases, the one with target == 0, is added to the result by reference
            self.result.append(path)
            return
        
        # Logic
        # 0 case or do not choose case
        # Path is copied to avoid addition to the same reference list and getting the wrong values for our result
        self.helper(candidates, target, index + 1, path.copy())
        
        # 1 case or choose case
        path.append(candidates[index])
        # Index is same coz a number can be picked unlimited times
        self.helper(candidates, target - candidates[index], index, path.copy())
        
        

       