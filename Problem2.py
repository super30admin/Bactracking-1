# // Time Complexity : O(n4^n) where n is the length of num.
# // Space Complexity : O(n) where n is the length of num.
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Class Solution.
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.result = []
        
        def helper(nums, index,calc,tail,target,path):
            #base
            
            if index == len(nums):
                if calc == target:
                    self.result.append(path)
                return            
            #logic
            
            for i in range(index,len(nums)):
                if index != i and nums[index] =='0':
                    continue
                curr = int(nums[index:i+1])
                if index == 0:
                    helper(nums, i+1, curr,curr,target,path + str(curr))
                else:
                    # + case
                    helper(nums, i+1, curr + calc, curr,target,path + "+"+str(curr))
                    # - case
                    helper(nums, i+1, calc - curr, -curr,target,path + "-"+str(curr))
                    # * case
                    helper(nums, i+1, calc - tail + tail * curr, tail * curr,target,path + "*"+str(curr))
                    
                
                
        helper(num,0,0,0,target,"")
        return self.result
