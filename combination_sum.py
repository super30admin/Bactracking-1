# Time Complexity :exhaustive= O(2^(target+len)) backtracking= O((2^(target+len))
# Space Complexity :exhaustive= O((target+len)*(2^(target+len))) backtracking= O(target+len)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach


# loop based recursion.
class Solution:
    def helper(self, candidates, pivot, target):
        # base
        if(target<0 or pivot==len(candidates)):
            return
        if(target==0):
            self.result.append(self.path[:])
        
        # logic
        i=pivot
        while(i<len(candidates)):
            # action
            self.path.append(candidates[i])
            # resurse
            self.helper(candidates, i, target-candidates[i])
            # backtrack
            self.path.pop()
            i+=1
        

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result=[]
        self.path=[]
        self.helper(candidates, 0, target)
        return self.result
    


# Backtracking way
class Solution:
    def helper(self, candidates, i, target, path):
        # base
        if(target==0):
            self.result.append(path[:])
        if(target<=0 or i>=len(candidates)):
            return
        # logic
        # not choose
        self.helper(candidates, i+1, target, path)
        # choose
        # action
        path.append(candidates[i])
        # recurse
        self.helper(candidates, i, target-candidates[i], path)
        # backtrack
        path.pop()

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result=[]
        self.helper(candidates, 0, target, [])
        return self.result
    


# DeepCopy way exhaustive
class Solution:
    def helper(self, candidates, i, target, path):
        # base
        if(target==0):
            self.result.append(path)
        if(target<=0 or i>=len(candidates)):
            return
        # logic
        # not choose
        self.helper(candidates, i+1, target, path[:])
        # choose
        self.helper(candidates, i, target-candidates[i], path+[candidates[i]])


    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result=[]
        self.helper(candidates, 0, target, [])
        return self.result