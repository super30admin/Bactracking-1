# Time Complexity : O(2^n)
# Space Complexity : O(length of longest combination)

# The code ran on LeetCode

# At a time step, make a decision to whether include or not to include the element at pivot in the result. Keep adding elements until the accumulated sum is greater than or equal to the target. Add the path to final result if current sum is equal to the target

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        res = []; n = len(candidates)

        def helper(candidates, pivot, path, res, target):
            if (target < 0 or pivot == n):return
            if target == 0:
                res.append([i for i in path])
                return

            for i in range(pivot, n):
                path.append(candidates[i])

                helper(candidates, i, path, res, target - candidates[i])

                path.remove(path[-1])

        helper(candidates, 0, [], res, target)

        return res