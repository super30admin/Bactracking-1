'''
Time complexity: O(n^n)
Space complexity: O(n)
'''
class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        self.output = []
        if candidates is None or len(candidates) == 0:
            return self.output
        self.backtracking(candidates, target, 0, [])
        return self.output
    
    def backtracking(self, candidates, target, index, path):
        if target < 0:
            return
        if target == 0:
            self.output.append(list(path))
            return
        
        for i in range(index, len(candidates)):
            path.append(candidates[i])
            self.backtracking(candidates, target - candidates[i], i, path)
            path.pop()