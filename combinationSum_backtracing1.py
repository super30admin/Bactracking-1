"""
39. Combination Sum

Time = O(n^n) where n = number of elements in input array
space = O(n^n)
Successfully excecuted on leetcode

Approach:
1. Backtracking(DFS + recursion)
2. Sort the candidates to reduce number of recursive calls. 
3. Recursive function will have 5 parameters - index to process each element; path to store intermediat paths
4. At each step update the target by target - current_value, if new target value is 0 then add it to the path or backtrack
"""

class Combination:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        candidates.sort() # O(nlogn) time complexity, it won't change overall time 
        self.dfs(candidates, target, 0, [], res)
        return res

    def dfs(self, nums, target, index, path, res):
        print("path here", path)
        if target < 0:
            return  # backtracking
        if target == 0:
            res.append(path)
            return 
        for i in range(index, len(nums)):
            self.dfs(nums, target-nums[i], i, path+[nums[i]], res)
            
            