# Created by Aashish Adhikari at 6:16 PM 1/28/2021

'''
Time Complexity:
O(4 ^ n)

Space Complexity:
O(4 ^n)
'''

class Solution(object):

    def helper(self, nums, path, current_total, tail, index):

        # base case'
        if index == len(nums):
            if current_total == self.target:
                self.result.append(path)



        # logic
        for idx in range(index, len(nums)):

            # for no-op cases
            joined_numbers = nums[index: idx+1]

            if nums[index] == "0" and index != idx:
                pass
            else:
                if index == 0:
                    self.helper(nums, path+joined_numbers, int(joined_numbers), int(joined_numbers), idx+1)
                else:
                    # + case
                    #print(type(joined_numbers), type(current_total))
                    self.helper(nums, path + "+" + joined_numbers, current_total + int(joined_numbers), int(joined_numbers), idx+1)
                    # - case
                    self.helper(nums, path + "-" + joined_numbers, current_total - int(joined_numbers), -1 * int(joined_numbers), idx+1)
                    # * case
                    self.helper(nums, path + "*" + joined_numbers, current_total - tail + tail * int(joined_numbers), tail * int(joined_numbers), idx+1)










    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """

        if len(num) == 0:
            return []

        self.result = []
        self.target = target

        self.helper(num, "", 0, 0, 0)
        return self.result
