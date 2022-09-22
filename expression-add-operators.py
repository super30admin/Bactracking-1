'''
Time Complexity - O(4^n) where n is length of array
Space Complexity - O(n)
'''


class Solution:
    def addOperators(self, nums: str, target: int) -> List[str]:
        if not nums:
            return []
        self.result = []
        self.helper(nums, 0, 0, 0, "", target)
        return self.result

    def helper(self, nums, pivot, calc, tail, path, target):
        if pivot == len(nums) and calc == target:
            self.result.append(path)
            return

        for i in range(pivot, len(nums)):
            if nums[pivot] == "0" and i != pivot:
                continue
            curr = int(nums[pivot:i+1])
            if pivot == 0:
                self.helper(nums, i+1, curr, curr, path + str(curr), target)
            else:
                self.helper(nums, i+1, calc + curr, +curr,
                            path + "+" + str(curr), target)
                self.helper(nums, i+1, calc - curr, -curr,
                            path + "-" + str(curr), target)
                self.helper(nums, i+1, (calc - tail) + (tail*curr),
                            tail*curr, path + "*" + str(curr), target)