# Logic: 

# Here we need to perform three operations, all of which are binary. That means they all need two operands to work. 

# Example: '123'
# Choices:
# 1) Addition: '1+2' = 3
#   -Add: '3+3' = 6
#   -Sub: '3-3' = 0
#   -Mult: '3*3' = 9 (not correct. Problem arises). For multiplication we need to adopt a slight different logic. (Calculated value so far - value that was added or subtracted) + ( value that was added or subtracted * Current value). So 3-2 + 2 * 3 = 7 which is correct.

# 2) Subtraction: '1-2' = -1
# 3) Multiplication: '1*2' = 2
# 4) No operator (append operands): '12' = 12

# Approach: Recursive

# Now during recursion we have to maintain 6 arguments for each call:
# 1) Given string
# 2) Target value we need to achieve
# 3) Path that we have calculated for that call
# 4) Calculated value for that call
# 5) Tail value: Previous operand that we worked with
# 6) Index of pointer in the given string

# We have 4 choices to make for recursion call:
# 1) Do not choose any operator and just concatenate current character value to the path and increment the index
# 2) Choose '+', append operator and current character value to path and add the its integer value from calculated value so for. increment the index
# 3) Choose '-', append operator and current character value to path and subtract the its integer value from calculated value so for. increment the index
# 4) Choose '*', append operator and current character value to path and use the formula explained above to update calculated value. increment the index

# There is an exceptional case we also need to handle for strings like '105' and target = 5
# Now according to our logic it will give out three answers for this: '1*0+5', '1*5', '10-5'. Out of which second path is wrong because 05 is converted to 5. To solve this, we just need to add a condition where if current characted is 0 and if its index does not match with indices we will traversing ahead, we need to skip it to avoid constructing any number starting with '0'.

# Time complexity: Exponential O(4^n)
# Space complexity: O(4^n * k); where n = length of given array; k = maximum lenght of path 

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.result = []
        if num == None or len(num) == 0:
            return self.result
        
        self.helper(num, target, "", 0, 0, 0)
        return self.result
    
    def helper(self, num, target, path, calc, tail, index):
        print("Path: ", path)
        print("Result: ", self.result)
        # base
        if index == len(num):
            if calc == target:
                self.result.append(path)
            return 
        
        #logic
        for i in range(index, len(num)):
            
            if num[index] == '0' and index != i:
                continue
                
            # We do not do anything but append two operands together
            curr = int(num[index: i + 1])
            
            if index == 0:
                self.helper(num, target, path + str(curr), curr, curr, i + 1)
            else:
                # +
                self.helper(num, target, path + "+" + str(curr), calc + curr, curr, i + 1)
                
                # -
                self.helper(num, target, path + "-" + str(curr), calc - curr, -curr, i + 1)
                
                # *
                self.helper(num, target, path + "*" + str(curr), calc - tail + tail * curr, tail * curr, i + 1)
                

# Approach: Backtracking

# In backtracking the logic remains the same. Only thing we need to do is backtrack when we hit the base case. In our case backtrack means updatinng the path by deleting the element that was added in the last call.

# Time complexity: O(4^n)
# Space complexity: O(k); where k = maximum lenght of path 

# Here space complexity came down to O(n) because 
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.result = []
        if num == None or len(num) == 0:
            return self.result
        
        self.backtrack(num, target, "", 0, 0, 0)
        return self.result
    
    def backtrack(self, num, target, path, calc, tail, index):
        
        # base
        if index == len(num):
            if calc == target:
                self.result.append(path)
            return 
        
        #logic
        for i in range(index, len(num)):
            if num[index] == '0' and index != i:
                continue
                
            curr = int(num[index: i + 1])
            l = len(path)
            
            if index == 0:
                path += str(curr)
                self.backtrack(num, target, path, curr, curr, i + 1)
                path = path[:l]
                
            else:
                # +
                path += "+" + str(curr)
                self.backtrack(num, target, path , calc + curr, curr, i + 1)
                path = path[:l]
                
                # -
                path += "-" + str(curr)
                self.backtrack(num, target, path , calc - curr, -curr, i + 1)
                path = path[:l]

                
                # *
                path += "*" + str(curr)
                self.backtrack(num, target, path , calc - tail + tail * curr, tail * curr, i + 1)
                path = path[:l]

                
                                