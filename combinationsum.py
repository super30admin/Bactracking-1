"""
https://leetcode.com/problems/combination-sum/
"""


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        ###recursion

        #         self.result=[]
        #         if candidates is None:
        #             return result
        #         self.helper(candidates, 0, target, [])
        #         return self.result
        #     def helper(self, candidates, index, target, path):
        #         ##base case
        #         if target==0:
        #             self.result.append(path)
        #             return
        #         if target<0 or index>=len(candidates):
        #             return
        #         ##logic

        #         ##not chose
        #         self.helper(candidates, index+1, target, list(path))

        #         ##chose
        #         path.append(candidates[index])
        #         self.helper(candidates, index, target-candidates[index], list(path))

        ##backtrack

        self.result = []
        if candidates is None:
            return result
        self.helper(candidates, 0, target, [])
        return self.result

    def helper(self, candidates, index, target, path):
        ##base case
        if target == 0:
            self.result.append(list(path))
            return
        if target < 0 or index >= len(candidates):
            return
            ##logic

        ##not chose
        self.helper(candidates, index + 1, target, path)

        ##chose
        path.append(candidates[index])
        self.helper(candidates, index, target - candidates[index], path)
        path.pop()

    ##for loop based recursion

