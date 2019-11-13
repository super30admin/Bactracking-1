# leetcode- 39
# Time - exponential
# iterate from each node and check till it sums up to the target (with repetition) -- here we decrement the target so till it becomes less than or equal to 0
class Solution:
    def combinationSum(self, candidates, target):
        # Edge case
        if not (candidates) or len(candidates) == 0:
            return []
        res = []
        self.helper(res, candidates, [], target, 0)  # call helper
        return res

    def helper(self, res, candidates, path, target, index):
        if target == 0:  # add path whenever target is equal to zero only
            res.append(list(path))  # as list changes evry time

        for i in range(index, len(candidates)):  # to omit travelling twice over same element
            if candidates[i] <= target:
                path.append(candidates[i])
                self.helper(res, candidates, path, target - candidates[i], i)
                path.pop()