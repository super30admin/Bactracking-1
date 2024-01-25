#Combination Sum (https://leetcode.com/problems/combination-sum/)

#Space Complexity = O(2^n)
#Time Complexity = O(n)

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        # Empty list to store result/ sum of combination
        res = []

        def dfs(start, target, path):
            #Base case
            if target == 0:
                res.append(path)
                return
            
            #combinations
            for i in range(start, len(candidates)):
                if candidates[i] > target:
                    continue
                dfs(i, target - candidates[i], path + [candidates[i]])

        #sorting candidates for faster search / optimization
        candidates.sort()
        dfs(0, target, [])
        return res


 

   


        