

from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        results = []

        def backtrack(remain, comb, start):

            # we found correct combination
            if remain == 0:
                # make a copy of the current combination
                results.append(list(comb))
                return

            # found combination is too big, stop this recursion call
            elif remain < 0:
                return

            # on each step array cand is getting smaller as we getting further in recursion.
            # This helps us to avoid duplicates in res.

            for i in range(start, len(candidates)):

                # add the number into the combination
                comb.append(candidates[i])

                # give the current number another chance, rather than moving on
                backtrack(remain - candidates[i], comb, i)

                # backtrack, remove the number from the combination
                comb.pop()

        backtrack(target, [], 0)

        return results
