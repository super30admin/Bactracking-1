#Time Complexity : O(2^L) where L is length of string
# Space Complexity : O(2^L) where 2^l times new array 
class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        sol = []
        index = 0
        curr = []
        

        def helper(nums, sol, index, curr =[] ):
            if index == len(nums)  or len(nums)== 0:
                sol.append(curr)
                return sol

            helper(nums, sol, index +1, curr [:])
            curr.append(nums[index])
            helper(nums, sol, index + 1, curr [:])
        helper(nums, sol, index, curr)
        return sol

=====================================================================
#Time Complexity : O(2^L) where L is length of string
# Space Complexity : O(N) where N is number of elements in array
class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = []
        if len(nums) == 0:
            return result
        
        def backtrack(nums,temp,index):
            result.append(temp[:])
            while(index < len(nums)):
                temp.append(nums[index])
                (backtrack(nums,temp,index+1))
                index+=1
                temp.pop()
                
                
        temp = []
        backtrack(nums,temp,0)
        return result
        