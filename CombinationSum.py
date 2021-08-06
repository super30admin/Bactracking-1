# Time Complexity : Exponential
# Space Complexity : O(n)

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if len(candidates) == 0:
            return None
        result = []
        self.backtrack(candidates, target, 0, [], result)
        return result

    def backtrack(self, candidates, target, index, path, result):
        # base
        if target == 0:
            result.append(path[:])
            print(result)
            # return result
        # logic
        if target < 0:
            return
        for i in range(index, len(candidates)):
            if target >= candidates[i]:
                path.append(candidates[i])
                self.backtrack(candidates, target - candidates[i], i, path, result)
                #if it returns because of any base condition, pop the last element
                path.pop()