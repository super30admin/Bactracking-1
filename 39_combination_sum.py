'''

## Problem 39: Combination sum

## Author: Neha Doiphode
## Date:   07-31-2022

## Description:
    Given an array of distinct integers candidates and a target integer target,
    return a list of all unique combinations of candidates where the chosen numbers sum to target.
    You may return the combinations in any order.

    The same number may be chosen from candidates an unlimited number of times.
    Two combinations are unique if the frequency of at least one of the chosen numbers is different.

    It is guaranteed that the number of unique combinations that sum up to target
    is less than 150 combinations for the given input.

## Examples:
    Example 1:
        Input: candidates = [2,3,6,7], target = 7
        Output: [[2,2,3],[7]]
        Explanation:
                    2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
                    7 is a candidate, and 7 = 7.
                    These are the only two combinations.

    Example 2:
        Input: candidates = [2,3,5], target = 8
        Output: [[2,2,2,2],[2,3,3],[3,5]]

    Example 3:
        Input: candidates = [2], target = 1
        Output: []

## Constraints:
    1 <= candidates.length <= 30
    1 <= candidates[i] <= 200
    All elements of candidates are distinct.
    1 <= target <= 500

## Notes:
    Backtracking technique incrementally builds candidates to the solutions.
    And abandons a candidate(backtracks) as soon as it determines that the candidate
    can not lead to a final solution.

    In this problem, we can incrementally build the combination and once we find that
    current combination is not valid, we backtrack and try another combination.

    Candidates: [3, 4, 5]
    Target    : 8

                                         [ ]
                 [3]                     [4]                     [5]
      [3, 3]    [3, 4]   [3, 5]     [4, 4] [4, 5]               [5, 5]

    [3, 3, 3] [3, 3, 4] [3, 4, 4] [3, 3, 5] [3, 5, 5] [3, 4, 5]
                                    [4, 4, 4] [4, 4, 5] [4, 5, 5]
                                    [5, 5, 5]

    Total number of leaf nodes = 10 ~= 3^(8/3) ~= 3^2 ~= 10

    Answer: [[3, 5],[4, 4]]

## Similar problems:
    Subsets
    Subsets II
    Permutations
    Permutations II
    Combinations
    Combination Sum II
    Combination Sum III
    Palindrome Partition


## Time complexity: Please refer to doc-strings of respective approaches used below to solve the problem.

## Space complexity: Please refer to doc-strings of respective approaches used below to solve the problem.

'''

from typing import List, Optional

def get_input():
    print("Enter integer elements of list(with spaces): ", end = "")
    l = input()
    l = [int(val) for val in l.split()]
    print("Enter the target sum: ", end = "")
    target = int(input())
    return l, target


class Solution:
    answer = []

    ############# SIMPLE RECURSION ################
    def dfs(self, candidates, target, combination, index):
        if target < 0 or index == len(candidates):
            return

        if target == 0:
            self.answer.append(combination)
            return

        # Don't choose case
        self.dfs(candidates, target, list(combination), index + 1)
        combination.append(candidates[index])
        # choose case
        self.dfs(candidates, target - candidates[index], list(combination), index)


    def combinationSum_recursive(self, candidates: List[int], target: int) -> List[List[int]]:
        """
        Time complexity :
        Space complexity:
        """
        if target < min(candidates) or len(candidates) == 0:
            return []

        self.answer = []
        combination = []
        self.dfs(candidates, target, combination, 0)

        return self.answer

    ############# BACKTRACKING ################
    def backtrack(self, candidates, target, combination, index):
        if target < 0 or index == len(candidates):
            return

        if target == 0:
            self.answer.append(list(combination))
            return

        # Don't choose case
        self.backtrack(candidates, target, combination, index + 1)
        combination.append(candidates[index])
        # choose case
        self.backtrack(candidates, target - candidates[index], combination, index)
        combination.pop()

    def combinationSum_backtrack(self, candidates: List[int], target: int) -> List[List[int]]:
        """
        Time complexity : O(N^T/M), where N is total number of candidates. T is target,
                                    M is minimal value present in candidates.

                           The execution of the backtracking is unfolded as a DFS traversal in a n-ary tree.
                           The total number of steps during the backtracking would be the number of nodes in the tree = N.
                           At each node, it takes a constant time to process, except the leaf nodes which could take a linear time
                           to make a copy of combination.
                           So we can say that the time complexity is linear to the number of nodes of the execution tree.

                           Fan-out at each leaf node would be bounded to N. Each leaf node can at the max contain 3(N) elements.
                           The maximal depth of the tree, would be T/M(8/3)​, where we keep on adding the smallest element to the combination.
                           The maximal number of nodes in N-ary tree of T/M​ height would be N^(T/M)​+1.

                           For example [3, 4, 5], target = 8 results into:

                                                                    [ ]
                                            [3]                     [4]                     [5]
                                 [3, 3]    [3, 4]   [3, 5]     [4, 4] [4, 5]               [5, 5]

                               [3, 3, 3] [3, 3, 4] [3, 4, 4] [3, 3, 5] [3, 5, 5] [3, 4, 5]
                                                               [4, 4, 4] [4, 4, 5] [4, 5, 5]
                                                               [5, 5, 5]

                          N = 3, T = 8, leaf nodes = 10, 3^(8/3) + 1 = 10.


        Space complexity: O(T/M) where T is target and M is minimal number in candiates.
                                We implement the algorithm in recursion, which consumes some additional memory
                                in the function call stack.

                                The number of recursive calls can pile up to T/M​,
                                where we keep on adding the smallest element to the combination.
                                As a result, the space overhead of the recursion is O(T/M).

                                In addition, we keep a combination of numbers during the execution,
                                which requires at most O(T/M) space as well.

                                The total space complexity of the algorithm would be O(T/M) + O(T/M) ~= O(T/M) asymptotical.

                                We did not take into the account the space used to hold the final results for the space complexity.

        """
        if target < min(candidates) or len(candidates) == 0:
            return []

        self.answer = []
        combination = []
        self.backtrack(candidates, target, combination, 0)

        return self.answer


    ############# FOR LOOP BASED BACKTRACKING ################
    def forloop_backtrack(self, candidates: List[int], target: int, combination: List[int], pivot: int) -> None:
        if target < 0:
            return

        if target == 0:
            self.answer.append(list(combination))

        # action
        for index in range(pivot, len(candidates)):
            combination.append(candidates[index])
            self.forloop_backtrack(candidates, target - candidates[index], combination, index)
            combination.pop()

    def combinationSum_forloop_backtrack(self, candidates: List[int], target: int) -> List[List[int]]:
        if target < min(candidates) or len(candidates) == 0:
            return []

        self.answer = []
        combination = []
        pivot = 0
        self.forloop_backtrack(candidates, target, combination, pivot)
        return self.answer


    ############# FOR LOOP BASED RECURSION ################
    def forloop_recursion(self, candidates: List[int], target: int, combination: List[int], pivot: int) -> None:
        if target < 0:
            return

        if target == 0:
            self.answer.append(combination)

        # action
        for index in range(pivot, len(candidates)):
            new_l = list(combination)
            new_l.append(candidates[index])
            self.forloop_recursion(candidates, target - candidates[index], new_l, index)

    def combinationSum_forloop_recursion(self, candidates: List[int], target: int) -> List[List[int]]:
        if target < min(candidates) or len(candidates) == 0:
            return []

        self.answer = []
        combination = []

        start = 0
        self.forloop_recursion(candidates, target, combination, start)

        return self.answer


# Driver code
solution = Solution()
l, target = get_input()
print(f"Input list: {l}")
print(f"Approach 1: using recursion   : Combination list which can sum up to target {target}: {solution.combinationSum_recursive(l, target)}")
print(f"Approach 2: using backtracking: Combination list which can sum up to target {target}: {solution.combinationSum_backtrack(l, target)}")
print(f"Approach 3: using for loop based recursion   : Combination list which can sum up to target {target}: {solution.combinationSum_forloop_recursion(l, target)}")
print(f"Approach 4: using for loop based backtracking: Combination list which can sum up to target {target}: {solution.combinationSum_forloop_backtrack(l, target)}")
