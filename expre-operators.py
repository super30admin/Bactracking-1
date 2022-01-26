from typing import List


class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        
        N = len(num)
        results = []
        
        def recurse(index, prev, curr, value, string):

            # processing of all the digits in num
            if index == N:

                # if the final value == target expected AND
                # no operand is left unprocessed
                if value == target and curr == 0:
                    results.append("".join(string[1:]))
                return

            # extending the current operand by one digit
            curr = curr * 10 + int(num[index])
            str_op = str(curr)

            if curr > 0:

                # no operation recursion
                recurse(index + 1, prev, curr, value, string)

            # addition operator
            string.append('+'); string.append(str_op)
            recurse(index + 1, curr, 0, value + curr, string)
            string.pop();string.pop()

            # can subtract or multiply only if there are some previous operands
            if string:

                # subtraction operator
                string.append('-'); string.append(str_op)
                recurse(index + 1, -curr, 0, value - curr, string)
                string.pop();string.pop()

                # multiplication operator
                string.append('*'); string.append(str_op)
                recurse(index + 1, curr * prev, 0, value - prev + (curr * prev), string)
                string.pop();string.pop()
                
        recurse(0, 0, 0, 0, [])    
        return results