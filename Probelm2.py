class Solution(object):
    def addOperators(self, num, target):
        """
        Time complexity - 4^n
        Space complexity - 4^n , n --> length of the input number
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        def backtrack(index, expression, last_operand, current_value):
            # Base case: If we have reached the end of the num string,
            # check if the current_value is equal to the target value.
            if index == len(num):
                if current_value == target:
                    result.append(expression)
                return

            # Loop through all possible lengths of the operand starting from the current index.
            for i in range(index, len(num)):
                # Convert the current operand to an integer value.
                operand = int(num[index:i+1])

                # If the index is 0, no need to add any operator.
                if index == 0:
                    backtrack(i + 1, str(operand), operand, operand)
                else:
                    # Try addition: update the current_value and expression.
                    backtrack(i + 1, expression + '+' + str(operand),
                              operand, current_value + operand)

                    # Try subtraction: update the current_value and expression.
                    backtrack(i + 1, expression + '-' +
                              str(operand), -operand, current_value - operand)

                    # Try multiplication: update the current_value and expression.
                    backtrack(i + 1, expression + '*' + str(operand), last_operand *
                              operand, current_value - last_operand + last_operand * operand)

                # Handle leading zeros in operands. If the operand is 0, no more operators can be added.
                if operand == 0:
                    break

        result = []  # Initialize an empty list to store all valid expressions.
        # Start the recursive backtracking from index=0 with empty expression.
        backtrack(0, '', 0, 0)
        return result
