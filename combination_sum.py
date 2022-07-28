# Time complexity: O(2^n)
# Space complexity: O(n)
# Approach: do recursion with case 0(dont include the number) and case 1(include the number)
# do backtracking to avoid call by reference in list.


class Solution:
    result = []
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        self.helper(candidates, target, 0, [])
        return self.result
    def helper(self, candidates, target, index,path):
        #base
        if target < 0 or index == len(candidates):
            return
        if target == 0:
            self.result.append(path.copy())
            return
        
        
        #logic
        self.helper(candidates,target, index+1, path)
        path.append(candidates[index])
        self.helper(candidates, target-candidates[index], index, path )
        path.pop()
    
        