# Time Complexity : O(2*n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I recursively choose and not choose all the numbers using a for loop and once I reach the sum
# I return the current path and as I go up the reursive stack I remove the last element in path
# to backtrack

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        
        def helper(candidates, index, path, target, current_sum):
            
            if current_sum == target:
                self.result.append([x for x in path])
                
            if current_sum > target or index>=len(candidates):
                return
            
            for i in range(index, len(candidates)):
                current_sum += candidates[i]
                path.append(candidates[i])
                helper(candidates, i, path, target, current_sum)
                current_sum -= candidates[i]
                path.pop()
                
        helper(candidates, 0, [], target, 0)
        
        return self.result