# // Time Complexity : O(4^n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        result = []
        if len(num) == 0:
            return result
        size = len(num)

        def construct(calc, exp, tail, index):
            if index >= size:
                if calc == target:
                    result.append(exp[:])
                return
            for i in range(index, size):
                # curr = ord(num[i]) - ord('0')
                if i != index and num[index] == "0":
                    continue
                curr = int(num[index:i+1])
                if index == 0:
                    construct(curr, exp + "" + str(curr), curr, i+1)

                else:
                    # add
                    construct(curr + calc, exp + "+" + str(curr), curr, i + 1)

                    # sub
                    construct(calc - curr, exp + "-" +
                              str(curr), -1 * curr, i + 1)
                    # mul
                    construct((calc - tail) + (tail * curr), exp +
                              "*" + str(curr), tail * curr, i + 1)

        construct(0, "", 0, 0)

        return result
