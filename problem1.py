#time O(2^m+n)
#space O(m+n)

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        def dfs(target, index, path):
            if target<0:
                return
            if target == 0:
                res.append(path)
                return 
            for i in range(index, len(candidates)):
                dfs(target-candidates[i],i,[candidates[i]]+path)
        res=[]
        dfs(target, 0, [])
        return res
        