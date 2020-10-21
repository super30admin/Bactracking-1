//Time Complexity: O(N (power(T/M)) + 1)
//Space Complexity: O(T/M)
//Run on Leetcode: Yes
//Any issues: No


class Solution(object):
    def combinationSum(self, candidates, target):
        candidates = sorted(candidates) 
        
        def backtracking(i, target, path):
            if target == 0:
                ans.append(path)
                return
            if i == len(candidates) or target < candidates[i]:
                return
            backtracking(i, target - candidates[i], path + [candidates[i]]) 
             backtracking(i + 1, target, path) 
        
        ans = []
        backtracking(0, target, [])
        return ans