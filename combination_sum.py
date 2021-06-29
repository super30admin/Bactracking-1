class Solution:
    '''
    t = target
    m = minimum
    Time Complexity: O(n * (t/m) + 1)
    Space Complexity: O(t/m)
    '''
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        
        def backtrack(remainder, comb, start):
            if remainder == 0:
                # copy the combination
                res.append(list(comb))
                return
            elif remainder < 0:
                # you have no more remainders so you don't have to search
                return
            
            for i in range(start, len(candidates)):
                
                comb.append(candidates[i])
                
                backtrack(remainder - candidates[i], comb, i)
                
                comb.pop()
        
        backtrack(target, [], 0)
        
        return res