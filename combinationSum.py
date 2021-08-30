"""
//Time :O(N^(T/M + 1)) where N = candidates, T=target, M=min among the candidates
Space: O(T/M)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO
"""
class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        self.result = []
        if len(candidates)== 0:
            return self.result
        self.backtrack(candidates,target,0,[])
        return self.result
    def backtrack(self,candidates,target,index,path):
        #base
        if(index == len(candidates) or target < 0):
            return
        if (target == 0):
            self.result.append(list(path))
            return
        #logic
        #do not choose
        self.backtrack(candidates,target,index + 1,path)
        #choose case
        #action
        path.append(candidates[index])
        #recurse
        self.backtrack(candidates,target- candidates[index],index,path)
        #backtrack
        path.pop(len(path)-1)
        #recursion solution
#         self.result = []
#         if len(candidates)== 0:
#             return self.result
#         self.recurse(candidates,target,0,[])
#         return self.result
#     def recurse(self,candidates,target,index,path):
#         #base
#         if(index == len(candidates) or target < 0):
#             return
#         if (target == 0):
#             self.result.append(path)
#             return
#         #logic
#         #do not choose
#         self.recurse(candidates,target,index + 1, list(path))
#         #choose case
#         path.append(candidates[index])
#         self.recurse(candidates,target- candidates[index],index,list(path) )
        