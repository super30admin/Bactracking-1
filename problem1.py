# Time Complexity: O(N^N)  N is the length of the candidates list.
# Space Complexity: O(N)

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        self.helper(candidates, 0, 0, target, [])
        return self.result
    def helper(self, candidates: List[int], pivot: int, total: int, target: int, path: List[int]):
        # base
        if total  > target:
            return
        if total == target:
            self.result.append(path[:])
        #logic
        for i in range(pivot, len(candidates)):
            # action
            path.append(candidates[i])
            # recurse
            self.helper(candidates, i, total + candidates[i], target, path)
            # backtrack
            path.pop()