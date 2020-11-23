class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        temp = []
        res = []
        
        def backtrack(temp, sum, index):
            #base
            if sum>target or index>=len(candidates):
                return
            if sum==target:
                res.append(temp.copy())
                return
            
            #logic
            
            for i in range(index, len(candidates)):
                #action
                temp.append(candidates[i])
                #recurse
                backtrack(temp, sum+candidates[i], i)
                #backtrack
                temp.pop()
        
        backtrack(temp, 0, 0)
        return res
                
            
        