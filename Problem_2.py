#39. Combination Sum


#Code:

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        output = []
        self.backtrack(candidates, target, output, [], 0)
        
        return output
    
    def backtrack(self, candidates, target, output, path, index):
        if target<0:
            return
        elif target==0:
            output.append(path[::])
        elif index>=len(candidates):
            return
        
        for i in range(index, len(candidates)):
            path.append(candidates[i])
            self.backtrack(candidates, target-candidates[i], output, path, i)
            path.pop()
        return

# Time Complexity: O(N^M)
# Space Complexity: O(N)
# Accepted on Leetcode: Yes