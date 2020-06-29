---------------------------------- Expression Add Operators Recursive -------------------------------------
# Time Complexity : O(4^N) N is the length of the s
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here I have used recursive solution where I choose a any of 3 symbols or not choose a symbol by iterating through num string.
#Here I choose the number and explore all the choices by calling recurse functions. and when I finishes reach my target, I am appending new s to the result array.
# I am checking one of the edge case as if the nums[i] == '0' and index == i, I am not calling recursive function.

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        if not num:
            return 
        
        def dfs(num, s,calc, tail, index, target):
            #base
            if index == len(num):
                if calc == target:
                    res.append(s)
                return 
        
            #logic
            
            for i in range(index,len(num)):
                if num[index] == '0' and i != index:
                    break
                curr = int(num[index:i+1])
                if index == 0:
                    dfs(num, s+str(curr), curr, curr, i+1, target)
                else:
                    #+
                    dfs(num, s+'+'+str(curr), calc+curr, curr, i+1, target)
                    #-
                    dfs(num, s+'-'+str(curr), calc-curr, -1*curr, i+1, target)
                    #*
                    dfs(num, s+'*'+str(curr), calc-tail+tail*curr, tail*curr , i+1, target)

            
            
        res = []
        dfs(num, "", 0, 0, 0,target)
        return res
        
        
---------------------------------- Expression Add Operators Backtracking-------------------------------------
# Time Complexity : O(4^N) N is the length of the s
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : No
# 
# Here I have used backtracking  solution where I choose a any of 3 symbols or not choose a symbol by iterating through num string.
#Here I choose the number and explore all the choices by calling recurse functions. and when I finishes reach my target, I am appending string to the result array.
# I am checking one of the edge case as if the nums[i] == '0' and index == i, I am not calling recursive function. Once I return the function, and change the length to the prev length 
#which means pop the elements.

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        if not num:
            return 
        
        def dfs(num, s,calc, tail, index, target):
            #base
            if index == len(num):
                if calc == target:
                    res.append("".join(list(s)))
                return 
        
            #logic
            
            for i in range(index,len(num)):
                if num[index] == '0' and i != index:
                    break
                curr = int(num[index:i+1])
                l = len(s)
                if index == 0:
                    s.append(str(curr))
                    dfs(num, s, curr, curr, i+1, target)
                    s.pop()
                else:
                    #+
                    s.append("+")
                    s.append(str(curr))
                    dfs(num, s, calc+curr, curr, i+1, target)
                    s = s[:l]
                    
                    #-
                    s.append("-")
                    s.append(str(curr))
                    dfs(num, s, calc-curr, -1*curr, i+1, target)
                    s = s[:l]
                    #*
                    s.append("*")
                    s.append(str(curr))
                    dfs(num, s, calc-tail+tail*curr, tail*curr , i+1, target)
                    s = s[:l]

            
            
        res = []
        dfs(num, [], 0, 0, 0,target)
        return res