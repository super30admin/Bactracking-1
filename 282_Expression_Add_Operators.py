# Leetcode problem link : https://leetcode.com/problems/expression-add-operators/
# Time Complexity:    O(4^n)
# Space Complexity:   O(n) for Backtracking
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
     1. Start from the first index and add to current path. Every element will have 4 branches (1 for appending next character and 3 for operations)
     2. Call backtracking recursively starting from next index and keep updating the expression
     3. For loop will iterate through all elements in the input always starting from next index and going till end

'''


class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        output = []
        self.backtrack(num, target, output, "", 0, 0, 0)
        return output
    
    def backtrack(self, num, target, output, expr, index, prevSum, prevAdd):
        # base case
        if index >= len(num):
            if prevSum == target:
                output.append(expr)
            return
            
        # recursive case
        
        # get current character(s)
        for i in range(index,len(num)):
            
            if num[index] == '0' and i != index:
                continue
            curr = int(num[index:i+1])
            # no operation to do at first index
            if index == 0:
                self.backtrack(num, target, output, expr + num[index:i+1], i + 1, curr, curr)
                
            else:
                # * branch

                self.backtrack(num, target, output, expr + "*" + num[index:i+1], i + 1, prevSum - prevAdd + prevAdd * curr, prevAdd * curr)

                # + branch
                self.backtrack(num, target, output, expr + "+" + num[index:i+1], i + 1, prevSum + curr, curr)

                # - branch
                self.backtrack(num, target, output, expr + "-" + num[index:i+1], i + 1, prevSum - curr, -curr)
        
        