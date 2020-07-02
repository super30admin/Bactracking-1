"""
// Time Complexity : in code
// Space Complexity : in code
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

"""

class Solution:
    """
    Recursive solution
    time complexity: o(2^n), choose not choose
    space complexity: o(n* 2^n), a new list is created at each point

    def helper(self, candidates, tmp, sum, idx):
        #base
        
        if idx >= len(candidates) or sum > self.targ:
            return
        if sum == self.targ:
            self.res.append(tmp) #copy not created as it is being sent from previous level
            return
               
        #logic
        #not choose
        self.helper(candidates, tmp.copy(), sum, idx + 1)
        
        #choose
        tmp.append(candidates[idx])
        self.helper(candidates, tmp.copy(), sum + candidates[idx], idx)
    """
    
    
    """
    backtracking solution
    time complexity: o(2^n), choose not choose in a way
    space complexity: o(n), same list is being used

    """
    def backtrack(self,candidates,tmp, sum, idx):
        
        for i in range(idx, len(candidates)):
            #base
            if sum > self.targ: #if by adding the current number we overshoot target, we return
                return
            
            if sum == self.targ: #if we found the combination adding up to target we add the list to result
                self.res.append(tmp.copy())
                return
            
            #action
            tmp.append(candidates[i]) #one list that keeps track of combinations
            #recurse
            self.backtrack(candidates, tmp, sum + candidates[i], i)
            #backtrack
            tmp.pop() #since we are using only one list, last added element has to be popper, this list will be empty at the end
    
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if not candidates:
            return []
        
        self.res = []
        self.targ = target
        
        self.backtrack(candidates, [], 0, 0) # sum = 0 and index = 0 initially
        
        return self.res