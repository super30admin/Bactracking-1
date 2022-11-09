class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        def recursion(candidates, remainder, index, path):
            
            # Base condition
            
            if remainder < 0 or len(candidates) == index:
                return
            
            # Base Consition
            
            if remainder == 0:
                result.append(path)
                return
        
            # Choose 0 where nothing is chosen
            recursion(candidates, remainder, index + 1, path.copy())
            
            path.append(candidates[index])
            
            # Choose 1 where value at index is chosen
            recursion(candidates, remainder - candidates[index], index, path.copy())
            
        result = []
        recursion(candidates, target, 0, [])
        return result
    
    # Goes through all the possible paths
    # Creating a new arraylist everytime because the reference is same. So extra space

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        def recursion(candidates, remainder, index, path):
            
            # Base condition
            
            if remainder < 0 or len(candidates) == index:
                return
            
            # Base Consition
            
            if remainder == 0:
                result.append(path.copy())
                return
        
            # Choose 0 where nothing is chosen
            recursion(candidates, remainder, index + 1, path)
            
            path.append(candidates[index])
            
            # Choose 1 where value at index is chosen
            recursion(candidates, remainder - candidates[index], index, path)
            path.pop()
            
        result = []
        recursion(candidates, target, 0, [])
        return result
    
    # Backtrack approach

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        def backtrack(candidates, remainder, start, path):
            
            # Base condition
            
            if remainder < 0:
                return
            
            # Base Condition
            
            if remainder == 0:
                result.append(path.copy())
                return
            # Keeping start here to make sure precedding elements are not considered in the combination
            for i in range(start, len(candidates)):
                
                path.append(candidates[i])
                
                # calling the backtrack on the same index until target found
                # If not the base condition wil return
                backtrack(candidates, remainder - candidates[i], i, path)
                
                path.pop() # and path will be popped andindex will be incremented
                
                
        result = []
        backtrack(candidates, target, 0, [])
        return result
    
# Time complexity: O(N ^ ((T/M) + 1)) where T is the target and M is the minimal element in candidates and N is the total number of candidates
# Space Complexity: O(T/M)