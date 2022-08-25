# Time Complexity : 
#  Space Complexity : O(N) due to copy of array size N, N is the number of elements
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

#  Your code here along with comments explaining your approach
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        n = len(num)
        result = []
        #Declare backtrack function to to explore every outcome and then adding the result accordingly
        def backtrack(i,prev,curr,val,expr):
            if i == n:
                if val == target and curr==0:
                    result.append(expr)
                return
            #To get thecurrent number
            curr = curr*10 + int(num[i])
        
            if curr>0:
                backtrack(i+1,prev,curr,val,expr)
            
            if not expr:
                backtrack(i+1,curr,0,val+curr,str(curr))
            else:
                backtrack(i+1, curr, 0, val+curr,expr + '+' + str(curr))
                backtrack(i+1, -curr, 0, val-curr,expr+ '-' + str(curr))
                backtrack(i+1, prev*curr, 0, val-prev + prev*curr, expr +'*'+ str(curr))
       
        backtrack(0,0,0,0,"")
        return result