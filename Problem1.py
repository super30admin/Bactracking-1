class Solution:
    # Time Complexity: O(2^(n+m))
    # Space Complexity: O(n)
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        self.helper(candidates, 0, target, [])
        return self.result

    def helper(self, candidates, i, target, path):
        if target < 0 or i == len(candidates):
            return
        if target == 0:
            self.result.append(list(path))
            return
        self.helper(candidates, i + 1, target, list(path))
        path.append(candidates[i])
        self.helper(candidates, i, target - candidates[i], list(path))
