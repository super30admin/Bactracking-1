class Solution:
    def combinationSum(self, candidates, target):
        results = []
        def helper(i, path):
            if sum(path) == target:
                results.append(path[:])
                return 
            if sum(path) > target:
                return 
            for x in range(i, len(candidates)):
                path.append(candidates[x])
                helper(x, path)
                path.pop()
        helper(0, [])
        return results

#Time-Complexity: O(n*2^n)
#Space-Complexity: O(n)