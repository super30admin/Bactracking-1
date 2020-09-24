# 282. Expression Add Operators

# Code:

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        
        output = []
        
        self.backtrack(output, num, target, 0, "", 0,0)
        return output
    
    
    def backtrack(self, output, num, target, idx, expr, prevSum, prevAdd):
        # base 
        if idx>=len(num):
            if prevSum==target:
                output.append(expr)
            return
        
        # recurse
        
        for i in range(idx,len(num)):
            curr = int(num[idx:i+1])
            
            if num[idx]=='0' and i!=idx:
                continue
                
            if idx==0:
                self.backtrack(output, num, target, i+1, expr+str(curr), curr, curr)
            else:
                
                # +
                self.backtrack(output, num, target, i+1, expr+'+'+str(curr), prevSum+curr, curr)
                
                # -
                self.backtrack(output, num, target, i+1, expr+'-'+str(curr), prevSum-curr, -curr)

                # *
                self.backtrack(output, num, target, i+1, expr+'*'+str(curr), (prevSum-prevAdd)+(prevAdd*curr), prevAdd*curr)
            
        return


# Time Complexity: O(N * (4^n))
# Space Complexity: O(N)
# Accepted on Leetcode: Yes