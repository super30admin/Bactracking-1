"""
282. Expression Add Operators


Time = O(n*4^n) where n = number of elements in input array; we have 4(1 base case + 3 operands) different choices at each step
space = O(n*4^n)
Successfully excecuted on leetcode

Approach:
1. Backtracking(DFS + recursion)
2. Recursion parameters  - num: remaining num string;temp: temporally string with operators added; 
    cur_string: current result of temp string; prev : previous multiply level number in temp
"""

class Expression:
    def addOperators(self, num, target):
        res = []
        self.target = target
        for i in range(1,len(num)+1):
            if i == 1 or (i > 1 and num[0] != "0"): #  "00*" is not allowed
                self.dfs(num[i:], num[:i], int(num[:i]), int(num[:i]), res) # put first number in the string
        return res

    def dfs(self, num, temp, cur_string, prev, res):
        if not num:
            if cur_string == self.target:
                res.append(temp)
            return
        for i in range(1, len(num)+1):
            val = num[:i]
            if i == 1 or (i > 1 and num[0] != "0"): # "00*" is not allowed
                self.dfs(num[i:], temp + "+" + val, cur_string+int(val), int(val), res)
                self.dfs(num[i:], temp + "-" + val, cur_string-int(val), -int(val), res)
                self.dfs(num[i:], temp + "*" + val, cur_string-prev+prev*int(val), prev*int(val), res)