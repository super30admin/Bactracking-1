class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []

        def helper(remaining, combinations, index):
            # Base condition
            if remaining == 0:
                # make a deep copy of the current combination
                result.append(list(combinations))
            if remaining < 0:
                # exceed the scope, stop exploration.
                return

            # logic
            for i in range(index, len(candidates)):
                combinations.append(candidates[i])
                # give the current number another chance, rather than moving on
                helper(remaining - candidates[i], combinations, i)
                combinations.pop()

        helper(target, [], 0)
        return result