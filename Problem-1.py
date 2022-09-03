# 39. Combination Sum

'''
Leetcode all test cases passed: Yes
Solution:
    def combinationSum(self, candidates, target):
        n is the no of candidates
        m is the target
        Time Complexity: O(2 ^ (m * n)) 
        Space Complexity: O(m + n)
'''
class Solution:
    def helper(self,candidates,target,idx,arr,curr_sum):
        #Base Condition
        if curr_sum == target:
            self.result.append(arr.copy())
            return
        if idx >= len(candidates) or curr_sum > target:
            return
        #Reccursion
        #choose
        arr.append(candidates[idx])
        self.helper(candidates,target,idx,arr,curr_sum + candidates[idx])
        arr.pop()
        #do not choose
        self.helper(candidates,target,idx + 1,arr,curr_sum)
        
    def combinationSum(self, candidates, target):
        self.result = []
        
        self.helper(candidates,target,0,[],0)
        return self.result   
