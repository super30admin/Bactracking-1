# Expression Add Opertors

# Time Complexity : Exponential
# Space Complexity : Exponential
# Did this code successfully run on Leetcode : Yes with Runtime 772 ms and Memory is 14.7 MB
# Any problem you faced while coding this : Initally yes, After class understanding no.
# Your code here along with comments explaining your approach
# Approach
"""
In recursive function we have string, target, path, what is calculated so far and last operation 
perfromed so far. The recursive calls will have calls for +,-,* and No(together string).  

"""
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        result = [] # for output
        self.bt(num, 0, 0, '', target, result)
        return result
    
    def bt(self, nxt, diff, sums, strr, target, result):
        if not nxt: 
            if sums == target: # Base Cases
                result.append(strr)
            return
        for i in range(1,len(nxt)+1):
            cur = nxt[:i]
            if len(cur)>1 and cur[0] == '0':
                return
            ns = nxt[i:]
            if not strr:
                self.bt(ns, int(cur), int(cur), cur, target, result)
            else:
                #plus
                self.bt(ns, int(cur), sums+int(cur), strr+"+"+cur, target, result)
                #minus
                self.bt(ns, -int(cur), sums-int(cur), strr+'-'+cur, target, result)
                #times
                self.bt(ns, diff*int(cur), (sums-diff)+(diff*int(cur)), strr+"*"+cur, target, result)