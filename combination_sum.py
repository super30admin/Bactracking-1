"""
Problem: 39. Combination Sum
Leetcode: https://leetcode.com/problems/combination-sum/
Solution: Backtracking algorithm - a DFS (Depth-First Search) tree traversal, with recursion using stack.
Time Complexity: O(N ^ T/M), where N is the number of candidates, T is the target value, M is the minimal value among the candidates
Space Complexity: O(T/M) as minimal value will take most space in stack
Works on Leetcode: Yes
"""


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        results = []
        self.backtrack(candidates, target, [], 0, results)
        return results

    def backtrack(self, candidates, remain, comb, start, results):
        if remain == 0:
            # make a deep copy of the current combination
            results.append(list(comb))
            return
        elif remain < 0:
            # exceed the scope, stop exploration
            return

        for i in range(start, len(candidates)):
            # add the number into the combination
            comb.append(candidates[i])
            # give the current number another chance, rather than moving on
            self.backtrack(candidates, remain - candidates[i], comb, i, results)
            # backtrack, remove the number from the combination
            comb.pop()


