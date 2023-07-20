"""
Problem : 1

Time Complexity : O()
Space Complexity : O()



Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Combination Sum

# Approach - 1
# Backtracking

class Solution(object):
    def __init__(self):
        self.result=[]
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """

        self.helper(candidates,0,target,[])
        return self.result
    
    def helper(self,candidates,idx,target,path):

        if idx>=len(candidates) or target<0:
            return

        if target==0:
            print(path)
            self.result.append(path[::])
            return
        
        # not choose
        self.helper(candidates,idx+1,target,path)
        
        # choose
        path.append(candidates[idx])
        self.helper(candidates,idx,target-candidates[idx],path)
        path.pop()


# Approach - 2
# Recursion

class Solution(object):
    def __init__(self):
        self.result=[]

    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """

        self.helper(candidates,0,target,[])
        return self.result
    
    def helper(self,candidates,idx,target,path):

        if idx>=len(candidates) or target<0:
            return

        if target==0:
            print(path)
            self.result.append(path)
            return
        
        
        # not choose
        self.helper(candidates,idx+1,target,path[::])

        # choose
        path.append(candidates[idx])
        self.helper(candidates,idx,target-candidates[idx],path[::])


# Approach - 3
# For Loop Based Recursion

class Solution(object):
    def __init__(self):
        self.result=[]


    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        self.helper(candidates,target,0,[])
        return self.result
    
    def helper(self,candidates,target,pivot,path):

        # base
        if target<0 or pivot==len(candidates):
            return
        if target==0:
            self.result.append(path[::])
            return
        

        # logic
        for i in range(pivot,len(candidates)):
            path.append(candidates[i])
            self.helper(candidates,target-candidates[i],i,path)
            path.pop()
