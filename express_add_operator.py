"""
Time Complexity : O(n(3^n) where n is the length num. This is equivalent to the number of nodes created
Space Complexity : O(n(3^n) where n is the length num. To create a copy of subsubstring.

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""


class Solution:
    def __init__(self):
        self.result = []

    def addOperators(self, num: str, target: int) -> List[str]:
        if len(num) == 0:
            return self.result
        self.helper(num, target, 0, 0, 0, "")
        return self.result

    def helper(self, num, target, pivot, calc, tail, expression):
        # base
        if pivot == len(num) and calc == target:
            self.result.append(expression)
            return

        # logic
        for i in range(pivot, len(num)):
            curr = int(num[pivot:i+1])
            if num[pivot] == "0" and pivot != i:
                continue
            if pivot == 0:
                self.helper(num, target, i+1, curr,
                            curr, expression + str(curr))
            else:
                # +
                self.helper(num, target, i+1, calc + curr,
                            curr, expression + "+" + str(curr))

                # -
                self.helper(num, target, i+1, calc - curr, -
                            curr, expression + "-" + str(curr))

                # *
                self.helper(num, target, i+1, (calc - tail) + (curr*tail),
                            (curr*tail), expression + "*" + str(curr))
