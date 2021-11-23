#leecode 39 : combination sum
# time - exponential
# space - O(n)
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        result = []
        
        def helper(candidates, target, index, path):

            if target == 0:
                
                result.append(path.copy())
                
                return

            if target < 0 or index == len(candidates):
                
                return

            
            for i in range(index, len(candidates)):
                
                
                path.append(candidates[i])

                helper(candidates, target - candidates[i], i, path)
                
                path.pop()
        
        helper(candidates, target, 0, [])
        
        return result;