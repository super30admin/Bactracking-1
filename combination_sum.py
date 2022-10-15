#Time Complexity: O(N^(T/M)), #Let N be the number of candidates, T be the target value, and 
#M be the minimal value among the candidates.
#Space Complexity: O(T/M)
#Did it run on leetcode: yes

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:

        results = []

        def backtrack(remain, comb, start):
            if remain == 0:
                results.append(list(comb))
                return
            elif remain < 0:
                return

            for i in range(start, len(candidates)):
                comb.append(candidates[i])
                backtrack(remain - candidates[i], comb, i)
                comb.pop()

        backtrack(target, [], 0)

        return results