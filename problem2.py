'''
Time Complexity: O(4^n)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation: Create a complete space of all possible combinations and backtract whenever you overshoot the target.
'''
class Solution:
    def backTrack(self, result: List, num: str, target: int, index: int, expression: str, value: int,
                  prevSignedOperand: int):
        # Check if we have reached the goal or not
        if index == len(num):
            if value == target:
                result.append(expression)

            return

        # 1234
        # 1
        # 12
        # 123
        # 1234

        # try candidates
        for cursor in range(index, len(num)):
            # current operand #edge case for the value 0
            if index != cursor and num[index] == '0':
                break
            operand = int(num[index:cursor + 1])
            if index == 0:
                self.backTrack(result, num, target, cursor + 1, str(operand), operand, operand)
            else:
                self.backTrack(result, num, target, cursor + 1, str(expression) + "+" + str(operand), value + operand,
                               operand)

                self.backTrack(result, num, target, cursor + 1, str(expression) + "-" + str(operand), value - operand,
                               -1 * operand)

                self.backTrack(result, num, target, cursor + 1, str(expression) + "*" + str(operand),
                               value - prevSignedOperand + operand * prevSignedOperand, operand * prevSignedOperand)

    def addOperators(self, num: str, target: int) -> List[str]:
        result = []
        self.backTrack(result, num, target, 0, "", 0, 0)
        return result