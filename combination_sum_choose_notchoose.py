class Solution:
    def __init__(self):
        self.result = []

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if len(candidates) == 0:
            return self.result
        self.helper(candidates, target, 0, [])
        return self.result

    def helper(self, candidates, amount, index, path):
        # base
        if amount < 0 or index == len(candidates):
            return
        if amount == 0:
            self.result.append(path[:])
            return

        # logic
        self.helper(candidates, amount, index+1, path)
        path.append(candidates[index])
        self.helper(candidates, amount-candidates[index], index, path)
        path.pop()
