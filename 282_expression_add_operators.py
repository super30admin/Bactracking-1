from typing import List


class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        """
            https://leetcode.com/problems/expression-add-operators/
            // Time Complexity : Exponential O(n*4n)
                    'n' is the number of numbers in the string num.
            // Space Complexity : O(n)
            // Three line explanation of solution in plain english:
               When we use dfs to do this question, the most tricky part is that how to deal with multiplication.
               For every addition and subtraction, we just directly adding or subtracting the new number.
               However, for multiplication, we should multiply current number and previous number firstly,
               and then add previous previous number.
               So we can use a variable preNum to record every previous number in each recursion step.
               If current recursive call is trying multiplication,
               we should use previous calculation value subtract previous number,
               and then adding multiplication result between previous number and current number.
        """
        result = []
        self._backtrack(result, "", num, target, 0, 0, 0)
        return result

    def _backtrack(self, result: List[int], path: str, num: str, target: int, cal: int, tail: int, index: int):
        # base case
        if index == len(num):
            if cal == target:
                result.append(path)
            return
        # logic
        # start from first index of current position in num string, try all possible length of nums
        for i in range(index, len(num)):
            # edge case, preceding 0
            # if current position is 0, we can only use it as a single digit number, should be 0
            # if it is not a single digit number with leading 0, it should be considered as an invalid number
            if i != index and num[index] == '0':
                break
            # substring from index to i
            cur = int(num[index:i + 1])
            # first index
            # position 0 should be considered individually, since it does not have any operand character before curNum
            if index == 0:
                # calculated and tail value is current value
                self._backtrack(result, f'{path}{cur}', num, target, cur, cur, i + 1)
            else:
                self._backtrack(result, f'{path}+{cur}', num, target, cal + cur, cur, i + 1)
                self._backtrack(result, f'{path}-{cur}', num, target, cal - cur, -cur, i + 1)
                # trick part: to calculate multiplication, we should subtract previous number,
                # and then add current multiplication result to the subtraction result
                self._backtrack(result, f'{path}*{cur}', num, target, cal - tail + tail * cur, tail * cur, i + 1)


if __name__ == '__main__':
    h = Solution()
    print(h.addOperators('105', 5))
