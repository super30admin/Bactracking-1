class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        self.result = []
        if len(candidates) == 1 and candidates[0] == None:
            return [candidates]
        self.helper(candidates, 0, target, [])
        
        return self.result
    
    def helper(self, candidates: List[int], index:int, target:int, path: List[int]):
         
        #base
        if target < 0:
            return
        if target == 0:
            self.result.append(path.copy())
       #     print("result", self.result)
            return
       
        #logic
        for i in range(index, len(candidates)):
            #action
            path.append(candidates[i])
            #recursion -- keep using the same so i and not i+1
            self.helper(candidates, i, target- candidates[i] ,path)
            #backtrack
            path.pop(len(path)-1)
        