'''
## Problem 282: Expression add operators

## Author: Neha Doiphode
## Date:   07-31-2022

## Description:
    Given a string num that contains only digits and an integer target,
    return all possibilities to insert the binary operators '+', '-', and/or '*'
    between the digits of num so that the resultant expression evaluates to the target value.

    Note that operands in the returned expressions should not contain leading zeros.

## Examples:
        Example 1:
            Input: num = "123", target = 6
            Output: ["1*2*3","1+2+3"]
            Explanation: Both "1*2*3" and "1+2+3" evaluate to 6.

        Example 2:
            Input: num = "232", target = 8
            Output: ["2*3+2","2+3*2"]
            Explanation: Both "2*3+2" and "2+3*2" evaluate to 8.

        Example 3:
            Input: num = "3456237490", target = 9191
            Output: []
            Explanation: There are no expressions that can be created from "3456237490" to evaluate to 9191.

        Example 4:
            Input: num = "105", target = 5
            Output: ["1*0+5","10-5"]
            Explanation: There is a leading zero in this input which needs to be handled separately.

## Notes:
                        1                                 2               3
      1 + 2           1 - 2          1 * 2
      1 + 2 + 3       1 - 2 + 3      1 * 2 + 3
      1 + 2 - 3       1 - 2 - 3      1 * 2 - 3
      1 + 2 * 3       1 - 2 * 3      1 * 2 * 3

     1. We need following values per step:
        * Expression
        * Current value
        * Calculated value
        * Tail

    2. Table: Example: 1 + 2 * 3 * 4
                calculated value                                 tail
            +     calc + current                              + current
            -     calc - current                              - current
            *    (calc - tail) + (tail * current)             + (tail * current)
                old calc = 7(1 + 2 * 3)
                old tail = 6(2 * 3)
                current = 4

                (old calc - old tail) = 7 - 6 = 1
                 old tail * current   = 6 * 4 = 24
        total =  (old calc - old tail) + (old tail * current) = 1 + 24 = 25(1 + 2 * 3 * 4)

     Precedence   : Used in an expression with more than one operator with different precedence to determine which operation to perform first.
     Associativity: If an expression contains two or more operators with the same precedence then Operator Associativity is used to determine.
                    It can either be Left to Right or from Right to Left.
                    Example: ‘*’ and ‘/’ have the same precedence and their associativity is Left to Right,
                             so the expression “100 / 10 * 10” is treated as “(100 / 10) * 10”.

 ## Constraints:
    1 <= num.length <= 10
    num consists of only digits.
    -231 <= target <= 231 - 1


## Time complexity: Please refer to doc-strings of respective approaches used below to solve the problem.

## Space complexity: Please refer to doc-strings of respective approaches used below to solve the problem.

'''

from typing import List

def get_input():
    print("Enter the string: ", end = "")
    input_string = input()
    print("Enter the target value(int): ", end = "")
    target = int(input())
    return input_string, target

class Solution:
    result = []
    def helper(self, num: str, target: int, start_index: int, expression: str, calculated_value: int, tail_value: int) -> None:
        # base case
        if start_index == len(num):
            if calculated_value == target:
                self.result.append(expression)
            return

        # logic
        # for loop recursion
        for i in range(start_index, len(num)):
            # Extract from start index to current index
            # We will have leading zero when start index is set to 0 and i is not at start index
            # for example, 105, start index = 1(0) and i = 2(5)
            if start_index != i and num[start_index] == '0':
                continue

            current_value = num[start_index:i+1]

            # If index is 0 then we have single element so there is no expression possible with single digit
            if start_index == 0:
                self.helper(num,
                            target,
                            i + 1,
                            expression + current_value,
                            int(current_value),
                            int(current_value))
            else:
                # + case
                self.helper(num,
                            target,
                            i + 1,
                            expression + '+' + current_value,
                            calculated_value + int(current_value),
                            int(current_value))

                # - case
                self.helper(num,
                            target,
                            i + 1,
                            expression + '-' + current_value,
                            calculated_value - int(current_value),
                            -int(current_value))

                # * case
                self.helper(num,
                            target,
                            i + 1,
                            expression + '*' + current_value,
                            (calculated_value - tail_value) + (tail_value * int(current_value)),
                            (tail_value * int(current_value)))

    def addOperators(self, num: str, target: int) -> List[str]:
        '''
        Time complexity : O(4^N), At every step along the way, we consider exactly 4 different choices or 4 different recursive paths.
                            The base case is when the value of index reaches N i.e. the length of the nums array.
                            Hence, our complexity would be O(4^N).

        Space complexity: O(4^N), Valid expressions do we add to our answers array.
                                   The space used up by the recursion stack would also be O(N), where N is length of input string.
                                   Since the size of recursion stack is determined by the value of index and it goes from 0 all the way to N.

                                   As far as substring formation goes, we are creating new substring every time, which goes onto the recursion stack each time,
                                   So space complexity also leads towards being exponential.
                                   We don't consider the space occupied by the answers array since that is a part of the question's requirement and we can't reduce that in any way.
        '''
        self.result = []
        if len(num) == 0:
            return result

        start_index = 0
        expression = ""
        calculated_value = 0
        tail_value = 0
        self.helper(num, target, start_index, expression, calculated_value, tail_value)
        return self.result


solution = Solution()
input_string, target = get_input()
print(f"Input string: {input_string}")
print(f"Approach 1: Recursion: Output expressions that result into target {target}: {solution.addOperators(input_string, target)}")
