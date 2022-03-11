# // Time Complexity : O(n*4^n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def addOperators(self, num: str, target: int):
        n = len(num)
        output = []
        
        # i -> start index, j -> list sofar, prev -> for *
        def dfs(i, j, res, prev):
            # base case
            if i>=n:
                if res == target:
                    output.append("".join(j)) 
                return
            
            # calculates the res and gets all possible solutions
            for k in range(i, n):
                cand = int(num[i:k+1])
                if not j:
                    dfs(k+1, [num[i:k+1]],cand,cand)
                else:
                    dfs(k+1,j+['+']+[num[i:k+1]],res+cand,cand)
                    dfs(k+1,j+['-']+[num[i:k+1]],res-cand,-cand)
                    dfs(k+1,j+['*']+[num[i:k+1]],res-prev+cand*prev,cand*prev)
                    
                # edge case: 100 -> '1' + '00'
                if num[i]=='0': break
        
        dfs(0,[],0,None)
        return output