class Solution:
    def __init__(self):
        self.result = None
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = list()
        if not candidates:
            return self.result
        
        self.backtrack(candidates, target, list(), 0)
        return self.result

    def backtrack(self, candidates, target, path:List[int], index):
        #base
        if target==0:
            self.result.append(list(path))
            
        if target<0:
            return
        
        #logic
        for i in range(index, len(candidates)):
            path.append(candidates[i])
            self.backtrack(candidates, target-candidates[i], path, i)
            path.pop()
        
