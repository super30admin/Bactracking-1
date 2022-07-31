# Time Complexity : O(nm) where n is the num of integers and m is the target
# Space Complexity : O(n) where n is the num of integers, max size of result array is if all candidates are in the list
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []

        def helper(comb, cursum, start):
            # Our current sum reached target
            if cursum == target:
                # We use .copy() because we don't want to change the original list
                result.append(comb.copy())
                return
            # Iterate and append until Target or end reached
            for idx in range(start, len(candidates)):
                if candidates[idx] + cursum <= target:
                    comb.append(candidates[idx])
                    helper(comb, cursum + candidates[idx], idx)
                    comb.pop()
            return


        helper([], 0, 0)
        return result
