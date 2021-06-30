class Solution:
    """Implementation using for loop, recursion, backtracking"""
    def __init__(self):
        self.result=[]
        
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        arr=[]
        self.helper(candidates, target, 0, arr)
        return self.result
    
    def helper(self, candidates, target, index, arr):
        if target==0:
            self.result.append(arr[:])
            return
        if target<0:
            return
        for i in range(index,len(candidates)):
            # copy=arr[:]
            arr.append(candidates[i])
            self.helper(candidates, target-candidates[i],i, arr)
            arr.pop()
        
    
    """BackTracking
    Time complexity- Exponential
    Space Complexity-O(n)"""    
    # def helper(self, candidates, target, index, arr):
    #     if target==0:
    #         self.result.append(arr[:])
    #         return
    #     if target<0 or index==len(candidates):
    #         return
    #     'first not choose, then choose part of code'
    #     self.helper(candidates, target, index+1,arr)
    #     arr.append(candidates[index])
    #     self.helper(candidates, target-candidates[index], index, arr)
    #     arr.pop()
    """first choose, then not choose part of code"""
        # copy=arr[:]
        # copy.append(candidates[index])
        # self.helper(candidates, target-candidates[index], index, copy)
        # self.helper(candidates, target, index+1,arr)
        # copy.pop()
        
    
    
"""Recursion"""
#     def helper(self, candidates, target, index, arr):
#         if target==0:
#             self.result.append(arr)
#             return
#         if target<0 or index==len(candidates):
#             return
#         """If choose is performed first, then create a copy of the array, else the not choose part will be appended with extra elements that are part of choose"""
#         copy=arr[:]
#         copy.append(candidates[index])
#         self.helper(candidates, target-candidates[index], index, copy[:])
#         self.helper(candidates, target, index+1,arr[:])
        
#         """Do the not choose part first and choose part next, so it would be easy to append
#         self.helper(candidates, target, index+1,arr[:])
#         arr.append(candidates[index])
#         self.helper(candidates, target-candidates[index], index, arr[:])"""
        
        