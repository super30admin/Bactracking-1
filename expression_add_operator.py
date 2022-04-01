# Time complexity :- O(n)
# Space complexity:- O(n)
class Solution:

    def addOperators(self, num: str, target: int) -> List[str]:
        self.result = []
        self.nums = num
        self.target = target
        self.addOperator1(0, 0, 0, [])

        return self.result

    def addOperator1(self, index, val, tail, ops):

        ##Base case

        if index == len(self.nums):

            if val == self.target:
                res = ""
                for re in ops:
                    res += re
                self.result.append(res)
            return

        ##recursion case

        for i in range(index, len(self.nums)):

            operstring = self.nums[index:i + 1]
            if len(operstring) >= 2 and operstring[0] == '0':
                return
            operand = int(operstring)

            if index == 0:
                ops.append(operstring)
                self.addOperator1(i + 1, operand, operand, ops)
                ops.pop()
            else:
                ##add
                ops.append('+' + operstring)
                self.addOperator1(i + 1, val + operand, operand, ops)
                ops.pop()

                # sub
                ops.append('-' + operstring)
                self.addOperator1(i + 1, val - operand, -operand, ops)
                ops.pop()

                # mul

                ops.append('*' + operstring)
                self.addOperator1(i + 1, val - tail + tail * operand, tail * operand, ops)
                ops.pop()


