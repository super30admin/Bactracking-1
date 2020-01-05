# Time Complexity : Exponential
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : YES

class Solution:
    def __init__(self):
        self.result = []
        
    def combinationSum(self, candidates, target):
        if not candidates:
            return self.result
        temp = []
        self.backtrack(candidates, target, 0, temp, 0)
        return self.result
    
    def backtrack(self, candidates, target, calculated, temp, index):
        #Base Case
        if calculated > target:
            return
        if calculated == target:
            self.result.append(list(temp))
        #Logic
        for i in range(index, len(candidates)):
            temp.append(candidates[i])
            self.backtrack(candidates, target, calculated + candidates[i], temp, i)
            #backtrack
            temp.pop(-1)