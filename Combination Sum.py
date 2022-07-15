""""// Time Complexity : 2^m/2  ~2^m
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""


# For-loop based Recursion-backtracking
class Solution:
    def __init__(self):
        self.result = []

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if not candidates:
            return self.result
        self.helper(candidates, target, 0, [])
        return self.result

    def helper(self, candidates, target, index, path):
        # base
        if target == 0:
            self.result.append(path[:])
        if target < 0:
            return
        # logic

        for i in range(index, len(candidates)):
            path.append(candidates[i])
            self.helper(candidates, target - candidates[i], i, path)
            path.pop()


# For-loop based Recursion- without backtracking
# class Solution:
#     def __init__(self):
#         self.result=[]
#     def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
#         if not candidates:
#             return self.result
#         self.helper(candidates, target, 0, [])
#         return self.result
#     def helper(self, candidates, target, index, path):
#         #base
#         if target==0:
#             self.result.append(path)
#         if target<0:
#             return
#         #logic

#         for i in range(index, len(candidates)):
#             li=path[:]
#             li.append(candidates[i])
#             self.helper(candidates, target-candidates[i], i, li)


""""// Time Complexity : 2^((target/min) + n) ~ 2^n
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
# 01 backtracking
class Solution:
    def __init__(self):
        self.result=[]
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if not candidates:
            return self.result

        self.helper(candidates, target, [], 0)
        return self.result

    def helper(self, candidates, target, path, i):
        if target==0:
            self.result.append(path[:])
            return
        if i==len(candidates) or target<0:
            return

        # no choose
        self.helper(candidates, target, path, i+1)

        #choose
        path.append(candidates[i])
        self.helper(candidates, target-candidates[i], path, i)

        path.pop()


# 01 brute force choose and then no choose
# class Solution:
#     def __init__(self):
#         self.result=[]
#     def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
#         if not candidates:
#             return self.result
#         self.helper(candidates, target, [], 0)
#         return self.result

#     def helper(self, candidates, target, path, i):
#         if target==0:
#             self.result.append(path)
#             return
#         if i==len(candidates) or target<0:
#             return

#         #choose
#         li=path[:]
#         li.append(candidates[i])
#         self.helper(candidates, target-candidates[i], li, i)
#         # no choose
#         self.helper(candidates, target, path[:], i+1)


# 01 brute force no choose and then choose
# class Solution:
#     def __init__(self):
#         self.result=[]
#     def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
#         if not candidates:
#             return self.result

#         self.helper(candidates, target, [], 0)
#         return self.result

#     def helper(self, candidates, target, path, i):
#         if target==0:
#             self.result.append(path)
#             return
#         if i==len(candidates) or target<0:
#             return

#         # no choose
#         self.helper(candidates, target, path[:], i+1)

#         #choose
#         path.append(candidates[i])
#         self.helper(candidates, target-candidates[i], path[:], i)


