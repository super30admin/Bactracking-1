"""
Time Complexity : O(4^N) where N is length of num array
Space Complexity : O(N) where N is length of num array
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.result = []
        self.goal = target
        if len(num) == 0:
            return self.result
        self.helper(num, 0, 0, 0, "")
        return self.result
    def helper(self, num, index, calc, tail, path):
        # Base
        if index == len(num):
            if calc == self.goal:
                self.result.append(path)
            return
        # Logic
        for i in range(index, len(num)):
            # The case where we encounter '0' before a number
            if num[index] == '0' and index != i: continue
            curr = int(num[index:i+1])
            currStr = num[index:i+1]
            if index == 0:
                self.helper(num, i + 1, curr, curr, path + currStr)
            else:
                # + operator
                self.helper(num, i + 1, calc+curr, curr, path +"+"+currStr)
                # - operator
                self.helper(num, i + 1, calc-curr, -curr, path+"-"+currStr)
                # * operator
                self.helper(num, i + 1, (calc-tail)+(tail*curr), tail*curr, path +"*"+currStr)