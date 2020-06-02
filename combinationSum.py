# Time complexity: O(N log N)
# Space complexity: O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def combinationSum(self, candidates: [int], target: int):
        nums = sorted(candidates)
        self.result = []
        self.backtracking([], 0, nums, target)
        return self.result

    def backtracking(self, tempList, start, nums, target):
        # edge case
        if target < 0:
            return
        if target == 0:
            self.result.append(list(tempList))
        else:
            for i in range(start, len(nums)):
                tempList.append(nums[i])
                self.backtracking(tempList, i, nums, target - nums[i])
                tempList.pop()

r = Solution()
candidates1 = [2,3,6,7]
target1 = 7
print("A solution set1 is:", r.combinationSum(candidates1,target1))
candidates2 = [2,3,5]
target2 = 8
print("A solution set2 is:", r.combinationSum(candidates2,target2))
