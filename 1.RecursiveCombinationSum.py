# Recursive Approach without dictionary
# // Time Complexity : O(2^N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :
class Solution:
    result = List[List[int]]
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = list()
        
        self.helper(candidates,target,list(),0)
        return self.result
    def helper(self, candidates, target, path, index):
        # base
        if(target==0):
            self.result.append(path)
            return
        if(target < 0 or index == len(candidates)):
            return 
        
        # logic
        # not choose
        self.helper(candidates,target,path+list(),index+1)
        
        # choose
        temp = path
        temp.append(candidates[index])
        self.helper(candidates,target-candidates[index],temp,index)    
    
# solution with choose first; note the difference in passing new list in logic /
# of recursive calls 
class Solution:
    result = List[List[int]]
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = list()
        
        self.helper(candidates,target,list(),0)
        return self.result
    def helper(self, candidates, target, path, index):
        # base
        if(target==0):
            self.result.append(path)
            return
        if(target < 0 or index == len(candidates)):
            return 
        
        # logic
         # choose
        temp = path + list()
        temp.append(candidates[index])
        self.helper(candidates,target-candidates[index],temp,index) 
        
        # not choose
        self.helper(candidates,target,path+list(),index+1)
        
          
    