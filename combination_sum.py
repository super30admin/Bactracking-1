

class Solution(object):
    def __init__(self):
        self.res=[]
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        :TC: exponential O(n^2)
        :SC:O(n)
        """
        
        self.helper(candidates, target,[],0)
        return self.res
    
    def helper(self, candidates, target,path, index):
        if target==0:
            cp=path[:]
            self.res.append(cp)
            return
        if target<0:
            return
        
        for i in range(index, len(candidates)):
            path.append(candidates[i])
            self.helper(candidates, target-candidates[i], path, i)
            path.pop()
            
        
#         # loop with backtracking sol
#         # p=[]
#         self.helper(candidates, target, 0, [])
#         return self.res
    
    
#     def helper(self, candidates, target, index, path):
#         # base
#         if target==0:
#             cp=path[:]
#             self.res.append(cp)
#             return
        
#         if target<0:  # index out of range condition will be accounted in for loop
#             return
        
#         for i in range(index, len(candidates)):
#             path.append(candidates[i])
#             self.helper(candidates, target-candidates[i], i, path)
#             path.pop()
  
    
#     def helper(self, candidates, target, index, path):
#         # base
#         if target==0:
#             cp=path[:]
#             self.res.append(cp)
#             return
#         if target<0 or index==len(candidates):
#             return
        
#         # not choose
#         self.helper(candidates, target, index+1, path)
        
#         # choose
#         path.append(candidates[index])
#         self.helper(candidates, target-candidates[index], index, path)
#         path.pop()
        
        
    
#        # recursive sol
#         self.helper(candidates, target, 0, [])
#         return self.res
    
#     def helper(self, candidates, target, index, path):
#         # base
#         if target==0:
#             self.res.append(path)
#             return
#         if target<0 or index==len(candidates):
#             return
        
#         # not choose
#         cp=path[:]
#         self.helper(candidates, target, index+1, cp)
        
#         # choose
#         cp=path[:]
#         cp.append(candidates[index])
#         self.helper(candidates, target-candidates[index], index, cp)
        
        