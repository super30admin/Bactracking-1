from typing import List

class Solution(object):
    def addOperators(self, nums: str, target: int) -> List[str]:
        self.result = []

        def helper(pivot, calc, tail, path):
            # base
            if pivot == len(nums):
                if calc == target:
                    self.result.append(path)
                return

            # logic
            for i in range(pivot, len(nums)):
                curr = int(nums[pivot:i+1])
                if nums[pivot] == '0' and i != pivot:
                    continue

                if pivot == 0:
                    helper(i + 1, curr, curr, path + str(curr))
                else:
                    # +
                    helper(i + 1, calc + curr, curr, path + "+" + str(curr))

                    # -
                    helper(i + 1, calc - curr, -curr, path + "-" + str(curr))

                    # *
                    helper(i + 1, calc - tail + tail * curr, tail * curr, path + "*" + str(curr))

        helper(0, 0, 0, '')
        return self.result
