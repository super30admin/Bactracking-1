# Time Complexity : O((2^n) * (3^n))
# Space Complexity : O(length of num + 3)

# The code ran on LeetCode

# Create all the possible numbers starting from a pivot and add expressions on them. Calculate value of a node in usual way for + and -. For *, remove the previously added element (tail) from the current sum, multiply current value with the tail and add it to the current sum. Update tail to tail * current value. Handle preceding 0 edge case by not considersing numbers that start with a 0.

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        res = []
        def helper(num, target, pivot, calc, tail, path):
            # Base
            if pivot == len(num):
                if calc == target:
                    res.append(path)
                return
            # Logic
            for i in range(pivot, len(num)):
                # The digits to be processed
                sub = num[pivot:i+1]
                # Convert String to integer
                if num[pivot] == '0' and i != pivot:continue
                cur = int(sub)
                if pivot == 0:
                    helper(num, target, i+1, cur, cur, path + str(cur))
                else:
                    # Operator
                    # +
                    helper(num, target, i+1, calc + cur, cur, path + '+' + str(cur))
                    # -
                    helper(num, target, i+1, calc - cur, -1*cur, path + '-' + str(cur))
                    # *
                    helper(num, target, i+1, (calc - tail) + (tail*cur), tail*cur, path + '*' + str(cur))
        helper(num, target, 0, 0, 0, '')

        return res