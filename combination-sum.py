'''
Time Complexity - O(2^n*m) where n is number of nodes and m is amount
Space Complexity - O(m + n) where m is amount and n is number of nodes
'''


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.res = []
        if not candidates:
            return res
        self.helper(candidates, 0, target, [])
        return self.res

    def helper(self, candidates, pivot, amount, path):
        if pivot == len(candidates) or amount < 0:
            return
        if amount == 0:
            self.res.append(list(path))
            return
        for i in range(pivot, len(candidates)):
            path.append(candidates[i])
            self.helper(candidates, i, amount-candidates[i], path)
            path.pop()