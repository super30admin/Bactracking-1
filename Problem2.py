## Problem2
# Expression Add Operators(https://leetcode.com/problems/expression-add-operators/)

# Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

# Example 1:

# Input: num = "123", target = 6
# Output: ["1+2+3", "1*2*3"] 
# Example 2:

# Input: num = "232", target = 8
# Output: ["2*3+2", "2+3*2"]
# Example 3:

# Input: num = "105", target = 5
# Output: ["1*0+5","10-5"]
# Example 4:

# Input: num = "00", target = 0
# Output: ["0+0", "0-0", "0*0"]
# Example 5:

# Input: num = "3456237490", target = 9191
# Output: []
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:

        def backtracking(i: int, path: str):
            if i == len(num) - 1:
                path += num[-1]
                if eval(path) == target:
                    paths.append(path)
            else:
                # concatenation only if no leading zero is generated (e.g. 05)
                if (path and path[-1] not in operators and num[i] == '0') or num[i] != '0':
                    backtracking(i + 1, path + num[i])
                for operator in operators:
                    backtracking(i + 1, path + num[i] + operator)

        paths = []
        operators = {'+', '-', '*'}
        backtracking(0, '')
        return paths
        