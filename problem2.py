# https://leetcode.com/problems/expression-add-operators/

# Time Complexity : O(2^N)
# Space Complexity : O(N) where N is the length of the element
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, failed with 0 cases. Fixed them with re.


# Your code here along with comments explaining your approach.
# Approach : We have three operators we can choose to add them or skip all of them. This is a backtracking problem.
# We can skip the operator, where we move our index in the string by 1 character. Or We can choose to select the index
# In this case if we select an operator, we then add it to the string and move the index by 2.
# Once we have reached the end, we evaluate the expression and check if it is equal to target. If not we will keep
# Exploring all the paths.

from typing import List
import re


class Solution:
    operators = ["+", "-", "*"]
    result = []

    def addOperators(self, num: str, target: int) -> List[str]:
        self.result = []
        self.recursion(num, 1, 0, target)
        return self.result

    def recursion(self, expression, cur_index, op_index, target):
        pattern = r'\b0\d+\b'
        if cur_index >= len(expression):
            if not re.search(pattern, expression) and eval(expression) == target:
                self.result.append(expression)
            return

        # No take
        self.recursion(expression, cur_index + 1, op_index, target)

        # Take
        for index in range(0, len(self.operators)):
            if cur_index < len(expression):
                new_expression = expression[:cur_index] + self.operators[index] + expression[cur_index:]
                self.recursion(new_expression, cur_index + 2, index, target)
