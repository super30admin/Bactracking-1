# Time Complexity : O(4^n) where n is the length of num
# Space Complexity : O(n)
from typing import List

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        def backtrack(expr, index, value, prev_operand):
            if index == len(num):
                if value == target:
                    result.append(expr)
                return

            for i in range(index, len(num)):
                if i != index and num[index] == '0':
                    break

                current_operand = int(num[index:i+1])

                if index == 0:
                    backtrack(expr + str(current_operand), i+1, current_operand, current_operand)
                else:
                    backtrack(expr + '+' + str(current_operand), i+1, value + current_operand, current_operand)
                    backtrack(expr + '-' + str(current_operand), i+1, value - current_operand, -current_operand)
                    backtrack(expr + '*' + str(current_operand), i+1, value - prev_operand + prev_operand * current_operand, prev_operand * current_operand)

        result = []
        backtrack('', 0, 0, 0)
        return result