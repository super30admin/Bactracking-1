# Time complexity: Exponential
# Space complexity: O(n) where n is the length of array (recursive stack)

# Recursive Approach:

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        if candidates is None or len(candidates) == 0:
            return self.result
        self.helper(candidates, target, 0, [])
        return self.result

    def helper(self, candidates, target, index, path):
        # terminating case
        if target == 0:
            self.result.append(path)
            return

        if target < 0 or index == len(candidates):
            return

        # logic
        # not picking element
        self.helper(candidates, target, index + 1, path)
        # picking element
        newList = path.copy()
        newList.append(candidates[index])
        self.helper(candidates, target - candidates[index], index, newList)



# Backtracking Approach

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        if candidates is None or len(candidates) == 0:
            return self.result
        self.helper(candidates, target, 0, [])
        return self.result

    def helper(self, candidates, target, index, path):
        # terminating case
        if target == 0:
            self.result.append(path.copy())
            return

        if target < 0 or index == len(candidates):
            return

        # logic
        # not picking element
        self.helper(candidates, target, index + 1, path)

        # picking element
        path.append(candidates[index])
        self.helper(candidates, target - candidates[index], index, path)
        # backtracking
        path.pop()





