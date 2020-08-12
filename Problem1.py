#Time complexity: O(2^n)
#Space complexity: O(n)
#Works on leetcode: yes
#Approach: Here we use a helper function taking the target, index and path as arguments. We iteratively recurse from the index
#to the length of candidates by reducing the target by current candidate, using current index and path plus current candidates
#to the helper
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        candidates.sort()
        def dfs(target,i, path):
            if target<0:
                return
            if target==0:
                res.append(path)
                return
            for k in range(i,len(candidates)):
                dfs(target-candidates[k],k, path+[candidates[k]])
        dfs(target, 0, [])
        return res