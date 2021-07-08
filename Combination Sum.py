"""
Apporoach 1: Recursive Solution
"""
from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result=[]
        if(candidates==None or len(candidates)==0):
            return self.result
        self.helper(candidates,target,0,[])
        return self.result

    def helper(self,candidates,target,index,path):
        #base
        if (target<0 or index==len(candidates)):
            return
        if target==0:
            self.result.append(path)
            return
        #logic
        #case 1 , not choose
        self.helper(candidates,target,index+1,path.copy())
        #case 2 choose
        path.append(candidates[index])
        self.helper(candidates,target-candidates[index],index,path.copy())

s=Solution()
print(s.combinationSum([2,3,6,7],7))

"""
Approach 2: Backtracking Way , here use the same path instead of creating new array list at every node
"""

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result=[]
        if(candidates==None or len(candidates)==0):
            return self.result
        self.helper(candidates,target,0,[])
        return self.result

    def helper(self,candidates,target,index,path):
        #base
        if (target<0 or index==len(candidates)):
            return
        if target==0:
            self.result.append(path.copy()) #put deep copy of path at root as recursion will flow back to empty list
            return
        #logic
        #case 1 , not choose
        self.helper(candidates,target,index+1,path)
        #case 2 choose
        path.append(candidates[index])
        self.helper(candidates,target-candidates[index],index,path)

        #backtrack
        path.pop()