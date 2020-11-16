#Time Complexity : O(n)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes
#Three line explanation of solution in plain english: Trying all combinations and seeing if the sum of it equals to the target, if it does, we add that combination of numbers to the result array. We find all these combinations by performing backtracking and maintaining an index and a temporary array in which we add values of the elements at the current index we are maintaining. We also keep a total running sum, which is of the elements in the temporary array. If anywhere the total running sum becomes greater than the target, then we return from there, after which the index in the for loop increases by 1 and moves to the next element.

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if not candidates or target < 0:
            return []

        self.result = []

        def findTarget(candidates, total, index, curr):
            if total == target:
                self.result.append(curr)
            elif total > target:
                return

            for i in range(index, len(candidates)):
                findTarget(candidates, total+candidates[i], i, curr+[candidates[i]])

        findTarget(candidates, 0, 0, [])
        return self.result
