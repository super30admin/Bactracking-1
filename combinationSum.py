class Solution:
    """
    TC: O(n^n) for every element there are n possiblities
    SC: O(max length of the path list + total valid combinations in output)
    """

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if len(candidates) == 0:
            return None

        output = []

        def backtrack(candidates, index, target, path):

            # target is negative
            if target < 0:
                return

            if target == 0:
                output.append(copy.deepcopy(path))
                return

            for i in range(index, len(candidates)):

                path.append(candidates[i])
                backtrack(candidates, i, target - candidates[i], path)
                path.pop()

        backtrack(candidates, 0, target, [])

        return output
