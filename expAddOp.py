"""

## Problem2
Expression Add Operators(https://leetcode.com/problems/expression-add-operators/)

Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Example 1:

Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"]
Example 2:

Input: num = "232", target = 8
Output: ["2*3+2", "2+3*2"]
Example 3:

Input: num = "105", target = 5
Output: ["1*0+5","10-5"]
Example 4:

Input: num = "00", target = 0
Output: ["0+0", "0-0", "0*0"]
Example 5:

Input: num = "3456237490", target = 9191
Output: []

time , space -not sure about time, please help

"""


class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.result = []
        self.helper(num, target, 0, 0, 0, "")

        return self.result

    def helper(self, num, target, calculated, tail, index, path):
        # base case
        if index == len((num)):
            if calculated == target:
                self.result.append(path)
                return

                # logic
        for i in range(index, len(num)):
            # for proceeding zeros
            if index != i and num[index] == '0': break

            curr = num[index: i + 1]

            if index == 0:
                self.helper(num, target, int(curr), int(curr), i + 1, path + curr)
            else:
                self.helper(num, target, calculated + int(curr), int(curr), i + 1, path + "+" + curr)
                self.helper(num, target, calculated - int(curr), -int(curr), i + 1, path + "-" + curr)
                self.helper(num, target, calculated - tail + tail * int(curr), tail * int(curr), i + 1,
                            path + "*" + curr)




