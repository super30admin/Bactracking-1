# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        def backtrack(total, cands, stack, output):
            # Base
            if total == target:
                output.append(stack)
                return
            if total > target or not cands:
                return
            # Logic
            backtrack(total, cands[1:], stack, output)
            backtrack(total + cands[0], cands, stack + [cands[0]], output)
            return output
        
        return backtrack(0, candidates, [], [])