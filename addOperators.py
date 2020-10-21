//Time Complexity: O(N * 4 powerN)
//Space Complexity: O(N)
//Run on Leetcode: Yes
//Any issues: No


class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        ans = []
        def helper(path, curval, pos, mulval):
            if pos==len(num) and target==curval:
                ans.append(path[1:])
                return 
            cur = 0
            for i in range(pos, len(num)):
                cur = int(num[pos:i+1])
                # plus
                helper(path+'+'+str(cur), curval+cur, i+1, cur)
                if pos>0:
                    helper(path+'-'+str(cur), curval-cur, i+1, -1*cur)                    
                    helper(path+'*'+str(cur), curval-mulval+mulval*cur, i+1, mulval*cur)
                if i==pos and cur==0:
                    break        
        helper('', 0, 0, 0)
        return ans