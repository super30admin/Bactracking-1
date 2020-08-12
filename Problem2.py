#Time complexity: O(n * 4^n)
#Space complexity: O(n)
#Works on leetcode: yes
#Approach: Here we use iterative/recursive backtracking solution. In the helper function if we the index is the length of num
#, we add the exp to the result and iterate from index to end of num and call helper function once when index=0 and 3 times
#for cases +, -, * otherwise. We use last to give precedence to *
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        res = []
        def dfs(total, i, last, exp):
            if i==len(num):
                if total==target:
                    res.append(exp)
            for j in range(i, len(num)):
                n = int(num[i:j+1])
                if i==0:
                    dfs(n,j+1,n,str(n))
                else:
                    dfs(total+n, j+1, n, exp+"+"+str(n))
                    dfs(total-n, j+1,-n, exp+'-'+ str(n))
                    dfs(total-last+last*n, j+1, last*n, exp+'*'+str(n))
                if n==0:
                    break
        dfs(0,0,0,'')
        return res