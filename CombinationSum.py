class Solution:
    def combinationSum(self, candidates, target: int):
        self.result = []
        def backtrack(target, i, comb):
            if target == 0:
                self.result.append(list(comb))
                return
            if target < 0:
                return
            
            for i in range(i, len(candidates)):
                comb.append(candidates[i])
                backtrack(target- candidates[i], i, comb)
                comb.pop()

        backtrack(target, 0, [])
        return self.result
    
#TC: O(n)
#SC: O(n)