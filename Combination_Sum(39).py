# Time Complexity: O(2^n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    # Backtracking Solution (for loop based)
    def __init__(self):
        self.result = list()

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.backtrack(candidates,target,0,list())
        return self.result

    def backtrack(self,candidates,target,index,path):
        if index==len(candidates) or target<0:
            return
        if target==0:
            self.result.append(path[:])
            return

        for i in range(index,len(candidates)):
            path.append(candidates[i])
            self.backtrack(candidates,target-candidates[i],i,path)
            path.pop()

    # For loop based Recursive Solution
    # def __init__(self):
    #     self.result = list()

    # def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
    #     self.recurse(candidates,target,0,list())
    #     return self.result

    # def recurse(self,candidates,target,index,path):
    #     if index==len(candidates) or target<0:
    #         return
    #     if target==0:
    #         self.result.append(path)
    #         return

    #     for i in range(index,len(candidates)):
    #         newlist = path[:]
    #         newlist.append(candidates[i])
    #         self.recurse(candidates,target-candidates[i],i,newlist)

    # BackTracking Solution 0-1
    # def __init__(self):
    #     self.result = list()

    # def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
    #     self.backtrack(candidates,target,0,list())
    #     return self.result

    # def backtrack(self,candidates,target,index,path):
    #     if index==len(candidates) or target<0:
    #         return
    #     if target==0:
    #         self.result.append(path[:])
    #         return
    #     #case when we dont choose the element
    #     self.backtrack(candidates,target,index+1,path)

    #     #if we decide to choose the current element
    #     path.append(candidates[index])
    #     self.backtrack(candidates,target-candidates[index],index,path)
    #     path.pop()

    # 0-1 Recursive Solution
    # def __init__(self):
    #     self.result = list()

    # def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
    #     self.recurse(candidates,target,0,list())
    #     return self.result

    # def recurse(self,candidates,target,index,path):
    #     if index==len(candidates) or target<0:
    #         return
    #     if target==0:
    #         self.result.append(path)
    #         return
    #     #case when we dont choose the element
    #     self.recurse(candidates,target,index+1,path[:])

    #     #if we decide to choose the current element
    #     path.append(candidates[index])
    #     self.recurse(candidates,target-candidates[index],index,path[:])