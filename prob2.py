# Time Complexity => Exponential O(x^N)
# Space Complexity => O(N)

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        n = len(num)
        result = []

        def helper(i,prev,curr,val,expr):
            if i == n:
                if val == target and curr==0:
                    result.append(expr)
                return

            curr = curr*10 + int(num[i])

            if curr>0:
                helper(i+1,prev,curr,val,expr)

            if not expr:
                helper(i+1,curr,0,val+curr,str(curr))
            else:
                helper(i+1,curr,0,val+curr,expr+'+'+str(curr))
                helper(i+1,-curr,0,val-curr,expr+'-'+str(curr))
                helper(i+1,prev*curr,0,val-prev+prev*curr,expr+'*'+str(curr))

        helper(0,0,0,0,"")
        return result
Footer
© 2022 GitHub, Inc.
Footer navigation
Terms
Privacy
Security
Status
Docs
Co