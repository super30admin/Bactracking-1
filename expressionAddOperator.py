'''
Time Complexity -->
O(4^n)

Space Complexity -->
O(4^n)
'''
class Solution:
    def addOperators(self, num, target):
        def dfs(l, r, expr, cur, last, res):
            if l == r:
                if cur == target:
                    res.append(expr)
                return
            for i in range(l + 1, r + 1):
                if i == l + 1 or (i > l + 1 and num[l] != "0"): # prevent "00"
                    s, x = num[l:i], int(num[l:i])
                    if last == None:
                        dfs(i, r, s, x, x, res)
                    else:
                        dfs(i, r, expr+"+"+s, cur + x, x, res)
                        dfs(i, r, expr+"-"+s, cur - x, -x, res)
                        dfs(i, r, expr+"*"+s, cur-last+last*x, last*x, res)
        
        res = []
        dfs(0, len(num), '', 0, None, res)
        return res
           
