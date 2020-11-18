# Time Complexity: O(4^N)
# Space Complexity: O(N)
# Approach: For every substring of nums array, we have 4 options-
# Noop - get the next digit
# Add
# Subtract
# Multiply
# Recurse over the input with all 4 options. The key here is to pass the result of the prev operation with every recursive call - when we multiply, we have to undo the previous operation, before performing the multiplication due to it's higher precedence.

class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        N = len(num)
        answers = []
        
        def backtrack(index, prev, curr, val, slate):
            if index == N:
                if val == target and curr == 0:
                    answers.append("".join(slate[1:]))
                return
            # NOOP, get next digit
            curr = curr*10 + int(num[index])
            str_op = str(curr)
            
            if curr > 0:
                backtrack(index+1, prev, curr, val, slate)
            # Add  
            slate.append('+') # Action
            slate.append(str_op) # Action
            backtrack(index+1, curr, 0, val + curr, slate) # Recurse
            slate.pop() # Backtrack
            slate.pop() # Backtrack
            
            if slate:
                # Subtract
                slate.append('-')# Action
                slate.append(str_op)# Action
                backtrack(index+1, -curr, 0, val-curr, slate) # Recurse
                slate.pop() # Backtrack
                slate.pop() # Backtrack
                
                # Mulltiply
                slate.append('*')# Action
                slate.append(str_op)# Action
                backtrack(index+1, curr*prev, 0, val - prev + (curr*prev), slate) # Recurse
                slate.pop() # Backtrack
                slate.pop() # Backtrack
        backtrack(0,0,0,0,[])
        return answers