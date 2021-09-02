class Solution:
    def __init__(self):
        self.result = []

    """
    Recursive method
    TC - O(n^2)
    SC - O(n^2)
    """

    def approach1(self, candidates, target, index, path):
        if target == 0:
            self.result.append(path)
            return
        if index == len(candidates) or target < 0:
            return
        self.approach1(candidates, target, index + 1, path.copy())
        path.append(candidates[index])
        self.approach1(candidates, target - candidates[index], index, path.copy())

    """
    Backtracking/iterative approach
    TC - O(n^2)
    SC - O(n)
    """

    def approach2(self, candidates, target, index, path):
        if target == 0:
            self.result.append(path.copy())
            return
        if target < 0:
            return
        for i in range(index, len(candidates)):
            path.append(candidates[i])
            self.approach2(candidates, target - candidates[i], i, path)
            path.pop()

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if not candidates or target < 0:
            return []
        self.approach2(candidates, target, 0, [])
        return self.result