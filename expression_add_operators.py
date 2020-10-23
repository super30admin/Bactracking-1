"""
Problem: 282. Expression Add Operators
Leetcode: https://leetcode.com/problems/expression-add-operators/
Solution: Backtracking algorithm
Time Complexity:
    - At every step, we consider exactly 4 different choices or 4 different recursive paths
    - The base case is when the value of index reaches N i.e. the length of the nums array. Hence, our complexity would be O(4^N)
    - For the base case we use a .join() operation in Python and that takes O(N) time. Here N represents the length of our expression.
    - In the worst case, each digit would be an operand and we would have N digits and N-1 operators. So O(N) for one expression.
    In the worst case, we can have O(4^N) valid expressions.
    - Overall time complexity = O(N * 4^N)
Space Complexity:
    - we have a list data structure that we update on the fly and only for valid expressions,
    we create a new string and add it to our answers array.
    - So, the space occupied by the intermediate list would be O(N) since in the worst case,
    the expression would be built out of all the digits as operands.
    - Additionally, the space used up by the recursion stack would also be O(N),
    since the size of recursion stack is determined by the value of index and
    it goes from 0 all the way to N.
    - We don't consider the space occupied by the answers array since that is a part of the question's requirement
    and we can't reduce that in any way.
Works on Leetcode: Yes
"""


class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        N = len(num)
        answers = []
        def recurse(index, prev_operand, current_operand, value, string):

            # Done processing all the digits in num
            if index == N:

                # If the final value == target expected AND
                # no operand is left unprocessed
                if value == target and current_operand == 0:
                    answers.append("".join(string[1:]))
                return

            # Extending the current operand by one digit
            current_operand = current_operand*10 + int(num[index])
            str_op = str(current_operand)

            # To avoid cases where we have 1 + 05 or 1 * 05 since 05 won't be a
            # valid operand. Hence this check
            if current_operand > 0:

                # NO OP recursion
                recurse(index + 1, prev_operand, current_operand, value, string)

            # ADDITION
            string.append('+'); string.append(str_op)
            recurse(index + 1, current_operand, 0, value + current_operand, string)
            string.pop();string.pop()

            # Can subtract or multiply only if there are some previous operands
            if string:

                # SUBTRACTION
                string.append('-'); string.append(str_op)
                recurse(index + 1, -current_operand, 0, value - current_operand, string)
                string.pop();string.pop()

                # MULTIPLICATION
                string.append('*'); string.append(str_op)
                recurse(index + 1, current_operand * prev_operand, 0, value - prev_operand + (current_operand * prev_operand), string)
                string.pop();string.pop()
        recurse(0, 0, 0, 0, [])
        return answers