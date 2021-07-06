from typing import List
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        if candidates == None or len(candidates) == 0:
            return self.result
        self.helper(candidates, target, 0, [])
        return self.result
    
    def helper(self, candidates: List[int], target: int, index: int, path: List[int]) -> None:
        # base case
        if target < 0 or index == len(candidates):
            return
        if target == 0:
            self.result.append(path)
            return
        
        # Logic
        # not choose
        self.helper(candidates, target, index + 1, path.copy())
        path.append(candidates[index])
        # choose
        self.helper(candidates, target - candidates[index] , index, path.copy())


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        if candidates == None or len(candidates) == 0:
            return self.result
        self.helper(candidates, target, 0, [])
        return self.result
    
    def helper(self, candidates: List[int], target: int, index: int, path: List[int]) -> None:
        # base case
        if target < 0 or index == len(candidates):
            return
        if target == 0:
            self.result.append(path.copy())
            return
        
        # Logic
        # not choose
        self.helper(candidates, target, index + 1, path)
        path.append(candidates[index])
        # choose
        self.helper(candidates, target - candidates[index] , index, path)
        
        # backtrack
        path.pop()
            
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        if candidates == None or len(candidates) == 0:
            return self.result
        self.helper(candidates, target, 0, [])
        return self.result
    
    def helper(self, candidates: List[int], target: int, index: int, path: List[int]) -> None:
        # base case
        if target == 0:
            # self.result.append(path)
            self.result.append(path.copy())
            return
        if target < 0:
            return
        
        # logic
        for i in range(index,len(candidates)):
            # deepCopy = path.copy()
            # deepCopy.append(candidates[i])
            path.append(candidates[i])
            self.helper(candidates, target - candidates[i], i, path)
            path.pop()
            
# Time Complexity: Exponential
        