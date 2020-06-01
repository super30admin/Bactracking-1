# Time complexity: O(3^N)
# Space complexity: O(3^N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def addOperators(self, num: str, target: int) :
        result = []
        self.backTrack(num, 0, 0, '', target, result)
        return result

    def backTrack(self, nxt, diff, sums, expression, target, result):
        if not nxt:
            if sums == target:
                result.append(expression)
            return
        for i in range(1, len(nxt) + 1):
            current = nxt[:i]
            if len(current) > 1 and current[0] == '0':
                return
            nums = nxt[i:]
            if not expression:
                self.backTrack(nums, int(current), int(current), current, target, result)
            else:
                # addition
                self.backTrack(nums, int(current), sums + int(current), expression + "+" + current, target, result)
                # subtraction
                self.backTrack(nums, -int(current), sums - int(current), expression + '-' + current, target, result)
                # multiplication
                self.backTrack(nums, diff * int(current), (sums - diff) + (diff * int(current)),
                               expression + "*" + current, target, result)

r = Solution()
num = "123"
target = 6
print("Output:", r.addOperators(num, target))

