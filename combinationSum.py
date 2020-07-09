class Solution(object):
    # Time Complexity : O(2^n), where n is the length of the candidates array.
    # Space Complexity : O(n*2^n), because a new list is created with each recursive call.
    # Did this code successfully run on Leetcode : yes
    # Any problem you faced while coding this : no

    # This approach is recursive, algorithm which explores all possible solutions.
    # a candidate is chosen or not chosen, and a array for all chosen candidates is maintained.
    # For all arrays whose sum equals target, the array is added to the result.
    def __init__(self):
        self.retVal = []
        self.cand = None
        self.target = None

    def combinationSumRecursive(self, candidates, target):
        if not candidates:
            return self.retVal
        self.cand = candidates
        self.target = target
        self.helper(0, 0, [])
        return self.retVal

    def helper(self, idx, sum, temp):
        if sum > self.target or idx == len(self.cand):
            return

        if sum == self.target:
            self.retVal.append(temp)
            return

        # case not choose
        self.helper(idx + 1, sum, list(temp))
        # case choose
        temp.append(self.cand[idx])
        self.helper(idx, sum + self.cand[idx], list(temp))

#------------------------------------------------------x---------------------------------------------------------------#

    # Time Complexity : O(2^n), where n is the length of the candidates array.
    # Space Complexity : O(m+n), where m is the target.
    # Did this code successfully run on Leetcode : yes
    # Any problem you faced while coding this : no

    # Your code here along with comments explaining your approach

    # This is a backtracking approach which explores all possible solutions.
    # All candidates are chosen, After every recursive call the candidate is removed.
    # Whenever the sum overshoots the target, that path is rejected.Whenever the sum
    # is met, a copy of the list is added. This solution saves space because a
    # copy is only added when the sum of the array is equal to target.
    def combinationSum(self, candidates, target):
        if not candidates:
            return self.retVal
        self.cand = candidates
        self.target = target
        self.backtrack(0, 0, [])
        return self.retVal

    def backtrack(self, idx, sum, temp):
        # if overshot target
        if sum > self.target:
            return
        # if equals target
        if sum == self.target:
            self.retVal.append(list(temp))
            return
        # iterate
        for i in range(idx, len(self.cand)):
            # action
            temp.append(self.cand[i])
            # recurse
            self.backtrack(i, sum + self.cand[i], temp)
            # backtrack
            temp.pop()
