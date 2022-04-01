# Time complexity:- O(2^target/min_no)
# Space comelxity:- O(n)
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []

        self.combinationSum2(candidates, 0, target, result)

        return result

    def combinationSum2(self, candidates, index, target, result, path=[]):

        # base case

        if index == len(candidates) or target < 0:
            return

        if target == 0:
            result.append(list(path))
            return

        # action
        path.append(candidates[index])

        # Choose case
        self.combinationSum2(candidates, index, target - candidates[index], result, path)

        # backtracking
        path.pop()

        # Not choose case
        self.combinationSum2(candidates, index + 1, target, result, path)



