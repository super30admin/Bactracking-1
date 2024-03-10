'''
TC: O(2^(m+n)) where m is the target and n is the number of inputs
SC: O(m+n) - height of the tree
'''
from typing import List

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.res = []
        L = len(candidates)

        def dfs(idx, target, path):
            #Base
            if target < 0:
                return
            if target == 0:
                self.res.append(list(path))
                return

            #Logic
            for i in range(idx, L):
                path.append(candidates[i])
                dfs(i, target-candidates[i], path)
                path.pop()

        dfs(0,target, [])
        return self.res
s = Solution()
print(s.combinationSum([2,3,6,7], 7))
print(s.combinationSum([2,3,5], 8))
print(s.combinationSum([2], 1))