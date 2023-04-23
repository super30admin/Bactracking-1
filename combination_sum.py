# Time Complexity: O(N^T) where N is the number of elements in the candidates list and T is the target
# Space Complexity: O(N) where N is the number of elements in the candidates list
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
We solve this problem with the 0/1 knapsack problem technique, where we choose to select an element 
or not select an element. Once we reach the end of the nums list we check if the sum is equal to the target, 
if so we add the current selection to the answer list. We also check if the sum is greater than the target, if so we return.
"""

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if candidates == None or len(candidates) == 0 or target == None: return 0
        # recursion 1
        self.candidates = candidates
        self.target = target
        self.curr_selection = []
        self.answer = []
        candidate_index = 0

        self.helper(candidate_index, target)

        return self.answer                  

    def helper(self, candidate_index, target):
        # base
        if candidate_index == len(self.candidates) or target < 0: return

        if target == 0: 
            self.answer.append(self.curr_selection.copy())
            return

        # don't choose
        self.helper(candidate_index + 1, target)

        # choose
        self.curr_selection.append(self.candidates[candidate_index])
        self.helper(candidate_index, target - self.candidates[candidate_index])

        self.curr_selection.pop()