# Runs on Leetcode
    # Runtime complexity - exponential, I am not sure what it is exactly
    # Memory complexity - O(1) without the recursive stack


class Solution:
    def combinationSum(self, candidates, target):
        if not candidates:
            return []
        self.result = []
        self.helper(candidates, target, 0, [], 0)
        return self.result
    
    def helper(self, nums, target, index, temp, Sum):
        if index > len(nums):
            return
        if Sum == target:
            self.result.append(list(temp))
        if Sum > target:
            return
        for i in range(index, len(nums)):
            temp.append(nums[i])
            self.helper(nums, target, i, temp, Sum + nums[i])
            temp.pop()
