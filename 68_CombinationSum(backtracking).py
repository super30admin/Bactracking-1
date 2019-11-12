# Accepted on leetcode(39)
# Time complexity : Exponential
# checking through each possible path and capturing the path whenever the target is zero
class Solution:
    def combinationSum(self, candidates, target):
        if len(candidates) == 0: return []  # Edge case
        result = []
        self.helper(result, candidates, [], target, 0)  # call helper
        return result

    def helper(self, result, candidates, path, target, index):
        if target == 0:  # if target is zero add path
            result.append(path[:])
            # range starts from index(to make sure same path is not traversed twice)
        for i in range(index, len(candidates)):
            if candidates[i] <= target:  # if the candidate 'i' is less than target then continue.
                path.append(candidates[i])
                self.helper(result, candidates, path, target - candidates[i], i)
                path.pop()

sol = Solution()
print(sol.combinationSum([1,2,3,5,7],8))