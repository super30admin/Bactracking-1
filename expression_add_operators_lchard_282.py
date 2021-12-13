class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        """
    procedure recurse(digits, index, expression):
2.     if we have reached the end of the string:
3.         if the expression evaluates to the target:
4.             Valid Expression found!
5.     else:
6.         try out operator 'NO OP' and recurse
7.         try out operator * and recurse
8.         try out operator + and recurse
9.         try out operator - and recurse

    Complexity Analysis

Time Complexity:

At every step along the way, we consider exactly 4 different choices or 4 different recursive paths. The base case is when the value of index reaches NN i.e. the length of the nums array. Hence, our complexity would be O(4^N)O(4
N
 ).
For the base case we use a StringBuilder::toString operation in Java and .join() operation in Python and that takes O(N)O(N) time. Here NN represents the length of our expression. In the worst case, each digit would be an operand and we would have NN digits and N - 1N−1 operators. So O(N)O(N). This is for one expression. In the worst case, we can have O(4^N)O(4
N
 ) valid expressions.
Overall time complexity = O(N \times 4^N)O(N×4
N
 ).
Space Complexity:

For both Python and Java implementations we have a list data structure that we update on the fly and only for valid expressions do we create a new string and add to our answers array. So, the space occupied by the intermediate list would be O(N)O(N) since in the worst case the expression would be built out of all the digits as operands.
Additionally, the space used up by the recursion stack would also be O(N)O(N) since the size of recursion stack is determined by the value of index and it goes from 00 all the way to NN.
We don't consider the space occupied by the answers array since that is a part of the question's requirement and we can't reduce that in any way


        """
        n = len(num)
        answers = []

        def helper(index, prev_operand, cur_operand, value, curexpr):
            if index == n:
                ###if value is target and no operand is left unprocessed
                if value == target and cur_operand == 0:
                    answers.append("".join(curexpr[1:]))
                return
            cur_operand = cur_operand * 10 + int(num[index])
            str_operand = str(cur_operand)
            ###no op recursion and to avoid cases like 1+05 and 1*05
            ###as 05 is not a valid operand

            if cur_operand > 0:
                helper(index + 1, prev_operand, cur_operand, value, curexpr)
            ###addition
            curexpr.append('+')
            curexpr.append(str_operand)
            helper(index + 1, cur_operand, 0, value + cur_operand, curexpr)
            curexpr.pop()
            curexpr.pop()

            ###caan subtract or multiply when there are previous operands
            if curexpr:
                ###subtract
                curexpr.append('-')
                curexpr.append(str_operand)
                helper(index + 1, -cur_operand, 0, value - cur_operand, curexpr)
                curexpr.pop()
                curexpr.pop()
                ###multiply
                curexpr.append('*')
                curexpr.append(str_operand)
                helper(index + 1, cur_operand * prev_operand, 0, value - prev_operand + (prev_operand * cur_operand),
                       curexpr)
                curexpr.pop()
                curexpr.pop()

                ###calling helper

        helper(0, 0, 0, 0, [])
        return answers

        ###subtraction and multiplication



