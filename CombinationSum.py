"""
Rasika Sasturkar
Brute force:
Time Complexity: O(m*n), n is total no. of elements in candidates list & m is target.
Space Complexity: O(n^2)
For-loop recursion:
Time Complexity: O(m*n), n is total no. of elements in candidates list & m is target.
Space Complexity: O(m+n)
"""


class Solution:
    """
    Can be solved in brute force way where we choose or not choose that value
    and use backtracking. In for-loop recursion, various combinations of values
    are generated when appending the value in the path and removing it (i.e.
    backtracking).
    """
    result = []

    # brute force
    # def combinationSum(self, candidates, target: int):
    #     self.result = []
    #
    #     # null case
    #     if candidates is None:
    #         return self.result
    #
    #     self.helper(candidates, 0, target, [])
    #     return self.result
    #
    # def helper(self, candidates, i, amount, path):
    #     # base case
    #     if amount < 0 or i == len(candidates):
    #         return
    #     if amount == 0:
    #         temp = path.copy()
    #         self.result.append(temp)
    #         return
    #
    #     # logic
    #     # not choose
    #     self.helper(candidates, i+1, amount, path)
    #     # choose
    #     path.append(candidates[i]) # action
    #     self.helper(candidates, i, amount-candidates[i], path) # recurse
    #     path.pop() # backtrack

    # Using for-loop recursion
    def combinationSum(self, candidates, target: int):
        self.result = []

        # null case
        if candidates is None:
            return self.result

        self.helper(candidates, 0, target, [])
        return self.result

    def helper(self, candidates, pivot, amount, path):
        # base case
        if amount < 0:
            return
        if amount == 0:
            temp = path.copy()
            self.result.append(temp)
            return

        # logic
        for i in range(pivot, len(candidates)):
            path.append(candidates[i])  # action
            self.helper(candidates, i, amount - candidates[i], path)  # recurse
            path.pop()  # backtrack


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    s = Solution()
    print(s.combinationSum(candidates=[2, 3, 6, 7], target=7))  # return [[2, 2, 3], [7]]
    print(s.combinationSum(candidates=[2, 3, 5], target=8))  # return [[2, 2, 2, 2], [2, 3, 3], [3, 5]]
    print(s.combinationSum(candidates=[2], target=1))  # return []


if __name__ == "__main__":
    main()
