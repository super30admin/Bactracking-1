# Time Complexity: O(n^t) - t - target value
# Space Complexity: O(n)
# call backtrack function on remaining value from terget and update the path accordingly
# and after the process is done for current iteration then update the path again i.e. backtrack
class Solution(object):
    result = []

    def backtrack(self, target, candidates, curr_result, curr_index):
        if target == 0:
            self.result.append(list(curr_result))
            return
        if target < 0:
            return

        for i in range(curr_index, len(candidates)):
            curr_result.append(candidates[i])

            self.backtrack(target - candidates[i], candidates, curr_result, i)
            curr_result.pop()

    def combinationSum(self, candidates, target):
        self.result = []
        self.backtrack(target, candidates, [], 0)
        return self.result
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
