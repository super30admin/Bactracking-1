class Solution: 

    def combinationSum(self, candidates, target):

        if len(candidates) == 0: return []

        result = []

        self.helper(result, candidates, [], target, 0)

        return result

    

    def helper(self,result, candidates, path, target, index):

        if target == 0:

            result.append(path[:])

        for i in range(index, len(candidates)):

            if candidates[i] <= target:

                path.append(candidates[i])

                self.helper(result, candidates, path, target - candidates[i], i)

                path.pop()

