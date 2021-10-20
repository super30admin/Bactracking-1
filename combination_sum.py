# Did this code successfully run on Leetcode : YES

# TC: O(N)
# SC: O(N)

# approach
# DFS

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []
        
        def helper(candidates, index, target, path):
            # base
            if target == 0:
                result.append(path)
                return
            if index == len(candidates) or target < 0:
                return
            # logic
            # case0 select candidates[index]
            helper(candidates, index, target-candidates[index], path+[candidates[index]])
            # case1 don't select
            helper(candidates, index+1, target, path)
            
        helper(candidates, 0, target, [])
        return result

# Did this code successfully run on Leetcode : YES

# TC: O(N)
# SC: O(N)

# approach
# backtracking

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []
        
        def helper(candidates, start, target, path):
            # base
            if target == 0:
                result.append(list(path))
                return
            if target < 0:
                return
            for i in range(start, len(candidates)):
                # action
                path.append(candidates[i])
                
                # recursion
                helper(candidates, i, target - candidates[i], path)
                # backtrack
                path.pop()
        helper(candidates, 0, target, [])
        return result