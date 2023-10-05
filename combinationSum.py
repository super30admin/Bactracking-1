# Time Complexity: O(2^m+n)
# Space Complexity: O(n)

class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        result = []

        def helper(candidates, index, path, remainingTarget):
            #base case
            if index >= len(candidates) or remainingTarget < 0:
                return
            if remainingTarget == 0:
                result.append(copy.deepcopy(path))
                return

            #action
            #not choose
            helper(candidates, index +1, path, remainingTarget)

            #choose
            path.append(candidates[index])
            helper(candidates, index, path, remainingTarget - candidates[index])
            path.pop()

        helper(candidates, 0, [], target)
        return result
