"""
Time Complexity : combinationSum() - O(n*4^n) - where n is the total number of elements in the input
Space Complexity : combinationSum() - O(1) [O(n) - stack space]
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : none
"""

class Solution:
    res = []
    def addOperators(self, num: str, target: int) -> List[str]:
        #if not num or len(num) == 0:
        #    return res 
        self.backtrack("", num, target, 0, 0, 0)
        return self.res
    def backtrack(self, path, num, target, calculated, tail, index):
        # base case
        if index == len(num):
            if calculated == target:
                self.res.append(path)
                return
                
        # recursive case
        for i in range(index, len(num)):
            # take care of preceding zero
            if i != index and num[index] == '0':
                break
            curr = int(num[index:i+1])
            if index == 0:
                self.backtrack(path + str(curr), num, target, curr, curr, i+1)
            else:
                self.backtrack(path + "+" + str(curr), num, target, calculated + curr, +curr,  i+1)
                self.backtrack(path + "-" + str(curr), num, target, calculated - curr, -curr, i+1)
                self.backtrack(path + "*" + str(curr), num, target, calculated - tail + tail * curr, tail*curr, i+1)
