# Time Complexity: O(2^n), where n is length of the input array
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes

# Solution:

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if not candidates or len(candidates) == 0:
            return []

        self.result = []
        self.dfs(candidates, target, 0, [])
        return self.result

    def dfs(self, candidates: List[int], target: int, index: int, path: List[int]) -> None:
        # base
        # If target is reached, add the path to the result
        if target == 0:
            self.result.append(list(path))
            return

        # Return when target becomes negative or index is out of bounds
        if target < 0 or index == len(candidates):
            return

        # logic
        # don't choose
        self.dfs(candidates, target, index + 1, path)
        # choose
        path.append(candidates[index])
        self.dfs(candidates, target - candidates[index], index, path)
        # backtrack
        path.pop()
