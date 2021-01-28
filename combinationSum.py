# Time Complexity : Exponential O(2^N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :  Not really.. just had to get started with backtracking


# Your code here along with comments explaining your approach


# class Solution:
#     def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
#         """
#         Recursion solution: TC: O(2^N)
                            # SC: O(N^2)
#         """
#         res = []
        
#         self.helper(candidates, [], 0, target,res)
        
#         return res 
    
#     def helper(self, candidates, path, index, target,res):
#         #base
#         if index == len(candidates) or target < 0:
#             return
#         if target == 0:
#             res.append(list(path))
#             return
        
#         #unchoose
#         self.helper(candidates, list(path), index+1, target, res)
#         #choose
#         path.append(candidates[index])
#         self.helper(candidates, list(path), index, target - candidates[index], res)
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        """
        Backtracking solution
        """
        res = []
        
        self.helper(candidates, [], 0, target,res)
        
        return res 
    
    def helper(self, candidates, temp, index, target,res):
        
        if index == len(candidates)  or target < 0:
            return
        
        if target == 0:
            res.append(list(temp))
        
        #logic 
        for i in range(index, len(candidates)):
            #choose
            temp.append(candidates[i])
            #explore
            self.helper(candidates, temp, i, target - candidates[i], res)
            #unchoose
            temp.pop()