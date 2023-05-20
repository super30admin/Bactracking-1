## Problem2
# Expression Add Operators(https://leetcode.com/problems/expression-add-operators/)

# Time Complexity: O(4^n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Approach: Backtracking

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        result = []
        if not num:
            return result

        def helper(num, target, index, calc, tail, path):
            # base
            if index == len(num):
                if calc == target:
                    result.append(path)
                return

            # logic
            for i in range(index, len(num)):
                if num[index] == '0' and index != i:
                    break
                curr = int(num[index:i+1])
                if index == 0:
                    helper(num, target, i+1, curr, curr, path + str(curr))
                else:
                    # +
                    helper(num, target, i+1, calc + curr, curr, path + '+' + str(curr))
                    # -
                    helper(num, target, i+1, calc - curr, -curr, path + '-' + str(curr))
                    # *
                    helper(num, target, i+1, calc - tail + tail * curr, tail * curr, path + '*' + str(curr))

        helper(num, target, 0, 0, 0, '')
        return result