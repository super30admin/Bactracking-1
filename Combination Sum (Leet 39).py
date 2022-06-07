# Time Complexity: Exponential

# For loop recursion
class Solution:
    res = list()
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.res = list()
        self.helper(candidates, target, 0, [])
        return self.res
    
    
    
    def helper(self, candidates, target, index, path):
        if target == 0:
            self.res.append(path.copy())
            return
        
        if target < 0:
            return
        
        for i in range(index, len(candidates)):
            path.append(candidates[i])
            self.helper(candidates, target-candidates[i], i, path)
            path.pop()




# DFS

class Solution:
    res = list()
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.res = list()
        if candidates is None or len(candidates) == 0:
            return self.res
        
        self.dfs(candidates, target, 0, [])
        return self.res
    
    
    def dfs(self, candidates, target, index, path):
        if candidates is None:
            return
        
        if target < 0: return
        if index >= len(candidates): return
        
        if target == 0:
            self.res.append(path.copy())
            return
        
        # not choose
        self.dfs(candidates, target, index+1, path)
        
        # choose
        path.append(candidates[index])
        self.dfs(candidates, target-candidates[index],index, path)
        path.pop()
        
