import copy
class Solution:
    result = []

    def combinationSum(self, candidates, target) :

        self.result = []

        if candidates == None or len(candidates) == 0:
            return self.result
        self.helper(candidates, target, 0, [])
        return self.result

    def helper(self, candidates, target, index, path):

        if target == 0:
            self.result.append(copy.deepcopy(path))
            return
        if target < 0 or index == len(candidates):
            return

        # dont choose
        # curr_path = []
        # curr_path.extend(path)
        self.helper(candidates, target, index + 1, path)

        # choose
        # curr_path1 = []
        # curr_path1.extend(path)
        path.append(candidates[index])
        self.helper(candidates, target - candidates[index], index, path)
        path.pop(-1)