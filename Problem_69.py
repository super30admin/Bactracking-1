# TC: O(2^(N + Height of the Tree))
# SC: O(2^(N + Height of the Tree))

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        def helper(pivot, path, target):
            #base
            if target < 0 :
                return
            if target == 0:
                self.result.append(list(path))
                return

            #dnt choose
            for i in range(pivot, len(candidates)):
            #action
                path.append(candidates[i])
                #recurse
                helper(i, path, target - candidates[i])
                #backtrack
                path.pop()

        self.result = []
        helper(0, [], target)
        return self.result