# Time Complexity : O(2^m) --> exponential.
# Space Complexity : O(n);
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# for loop based recursion
# TC: (2^m)/2 --> 2^m-1 --> 2^m; SC: O(n)
class Solution:
    def helper(self, candidates, target, index, path):
        # base
        if target == 0:
            self.result.append(path[:])
            return
        if target < 0:
            return
        # logic
        for i in range(index, len(candidates)):
            path.append(candidates[i])
            self.helper(candidates, target - candidates[i], i, path)
            # Back_track
            path.pop()

    def combinationSum(self, candidates: list[int], target: int) -> list[list[int]]:
        self.result = []
        self.helper(candidates, target, 0, [])
        return self.result


print(Solution().combinationSum([1, 2, 3], 3))

# Back-Tracking
# creating new path while appending it to result
# TC: 2^((target/min) + n) --> 2^n; SC: O(n)
# class Solution:
#     def helper(self, candidates, target, index, path):
#         # base
#         if target == 0:
#             self.result.append(path[:])
#             return
#         if target < 0 or index == len(candidates):
#             return
#         # logic
#         # no choose
#         self.helper(candidates, target, index+1, path)
#         # choose
#         path.append(candidates[index])
#         self.helper(candidates, target - candidates[index], index, path)
#         # Back-Track
#         path.pop()
#
#     def combinationSum(self, candidates: list[int], target: int) -> list[list[int]]:
#         self.result = []
#         self.helper(candidates, target, 0, [])
#         return self.result
#
#
# print(Solution().combinationSum([1, 2, 3], 3))


# Brute-Force Recursion
# creating new paths at each and every-time
# class Solution:
#     def helper(self, candidates, target, index, path):
#         # base
#         if target == 0:
#             self.result.append(path)
#             return
#         if target < 0 or index == len(candidates):
#             return
#         # logic
#         # no choose
#         self.helper(candidates, target, index+1, path[:])
#         # choose
#         path.append(candidates[index])
#         self.helper(candidates, target-candidates[index], index, path[:])
#
#     def combinationSum(self, candidates: list[int], target: int) -> list[list[int]]:
#         self.result = []
#         self.helper(candidates, target, 0, [])
#         return self.result
#
#
# print(Solution().combinationSum([1, 2, 3], 3))
