# // Time Complexity : O(exponential)
# // Space Complexity : O(Target/smallest element)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
	# Perform recursion with choose and and not choose case
	
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.res = []
        if not candidates:
            return res
        index = 0
        path =[]
        self.helper(candidates,index,target,path)
        return self.res
    
    def helper(self,candidates,index,target,path):
        ## Base logic
        if index == len(candidates) or target < 0:
            return
        if target == 0:
            self.res.append(path)
            return
        
        ## Recurcion
        self.helper(candidates,index+1,target,path.copy())
        path.append(candidates[index])
        self.helper(candidates,index,target - candidates[index],path.copy())
		
# // Time Complexity : O(exponential)
# // Space Complexity : O(Target/smallest element)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
	# Perform recursion with choose and and not choose case
	# After the exexution each node pop the last element so that the path is restored to 
	# previous node.(backtracking)
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.res = []
        if not candidates:
            return res
        index = 0
        path =[]
        self.helper(candidates,index,target,path)
        return self.res
    
    def helper(self,candidates,index,target,path):
        ## Base logic
        if index == len(candidates) or target < 0:
            return
        if target == 0:
            self.res.append(path.copy())
            return
        
        ## Recurcion
        self.helper(candidates,index+1,target,path)
        path.append(candidates[index])
        self.helper(candidates,index,target - candidates[index],path)
        
        path.pop()
	
# // Time Complexity : O(exponential)
# // Space Complexity : O(Target/smallest element)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
	# Perform pivot backtracking. Set an element and perform the recursion from next element to the
	# end of the element.This is basically the same approach as the previous backtracking only differencre
	# is that it is run in a for loop.
	
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.res = []
        if not candidates:
            return res
        index = 0
        path =[]
        self.helper(candidates,index,target,path)
        return self.res
    
    def helper(self,candidates,index,target,path):
        ## Base logic
        if index == len(candidates) or target < 0:
            return
        if target == 0:
            self.res.append(path.copy())
            return
        
        ## Recurcion
        
        ##Choose
        for i in range(index,len(candidates)):
            path.append(candidates[i])
            self.helper(candidates,i,target - candidates[i],path)
            path.pop()