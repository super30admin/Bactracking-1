class Solution:
    def __init__(self):
        self.result = None
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = list()
        if not candidates:
            return self.result
        
        self.backtrack(candidates, target, list(), 0)
        return self.result

    def backtrack(self, candidates, target, path:List[int], i):
        
        # base
        if target == 0:
            self.result.append(list(path))
            return
        
        if target<0 or i == len(candidates):
            return 
        #logic
        self.backtrack(candidates, target, path, i+1)
        path.append(candidates[i])
        self.backtrack(candidates, target-candidates[i], path, i)
        path.pop(len(path)-1)
        
