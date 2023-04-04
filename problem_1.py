# Time Complexity - O(N^M)
# Space Complexity - O(N^M)

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        self.helper(candidates, target, 0, [])
        return self.result 

    def helper(self, candidates, target, pivot, path):
        if target < 0:
            return
        if target == 0:
            self.result.append(path.copy())

        for i in range(pivot, len(candidates)):
            path.append(candidates[i])
            self.helper(candidates, target - candidates[i], i, path)
            path.pop()
