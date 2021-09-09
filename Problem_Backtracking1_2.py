class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        ans=[]
        def backtrack(index, pre, cur, value, s):
            if index == n:
                if value == target and cur == 0:
                    ans.append(s)
                
                return
            
            cur = cur * 10 + int(num[index])
            
            if cur > 0 :
                backtrack(index+1, pre, cur, value, s)
                
            if not s:
                backtrack(index+1, cur,0, value+cur, str(cur))
                
            else:
                backtrack(index+1, cur,0, value+cur, s+'+'+str(cur))
                backtrack(index+1, -cur,0, value-cur, s+'-'+str(cur))
                backtrack(index+1, pre*cur,0, (value-pre)+(pre*cur), s+'*'+str(cur))
                
        n=len(num)
        ans=[]
        backtrack(0,0,0,0,"")
        
        return ans


TC : O(nk)
SC : O(k)