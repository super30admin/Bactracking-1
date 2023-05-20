# Problem1
# Combination Sum (https://leetcode.com/problems/combination-sum/)


# Time Complexity: O(2^n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Approach: Backtracking

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []
        if not candidates:
            return result

        def helper(candidates, target, index, path):
            # base
            if target == 0:
                result.append(path)
                return
            if target < 0 or index == len(candidates):
                return

            # logic
            # dont choose
            helper(candidates, target, index+1, path)

            # choose
            temp = path.copy()
            temp.append(candidates[index])
            helper(candidates, target - candidates[index], index, temp)

        helper(candidates, target, 0, [])
        return result