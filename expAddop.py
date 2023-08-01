#TC - O(N*4^N)
#SC - O(N)
class Solution:
    def addOperators(self, num: 'str', target: 'int') -> 'List[str]':
        def dfs(index,pre,cur,value,s):
            if index == n:
                if value == target and cur == 0:
                    res.append(s)
                return
            cur = cur*10 + int(num[index])
            if cur>0:
                dfs(index+1,pre,cur,value,s)
            if not s:
                dfs(index+1,cur,0,value+cur,str(cur))
            else:
                dfs(index+1,cur,0,value+cur,s+'+'+str(cur))
                dfs(index+1,-cur,0,value-cur,s+'-'+str(cur))
                dfs(index+1,pre*cur,0,value-pre+pre*cur,s+'*'+str(cur))
        n = len(num)
        res = []
        dfs(0,0,0,0,"")
        return res
                

       