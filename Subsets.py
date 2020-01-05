# Time Complexity : Exponential
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : YES


class Solution:
    def __init__(self):
        self.result = []
        
    def subsets(self, nums):
        #Edge case
        if not nums:
            return self.result
        temp = []
        self.helper(nums, 0, temp)
        return self.result
    
    def helper(self, nums, index, temp):
        if index > len(nums):
            return
        self.result.append(temp[::])
        for i in range(index, len(nums)):
            temp.append(nums[i])
            self.helper(nums, i+1, temp)
            #BackTracking
            temp.pop(-1)
            
            

        
        
        
        