# // Time Complexity : O(2^(m+n)) where m is the target and n is the number of candidates. 
# // Space Complexity : O(2^n) where n is the number of candidates.
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Class Solution.


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        # method 1
#         self.result = []
#         def helper(candidates,index,remaining_target,path):
#             # base
#             if remaining_target == 0:
#                 self.result.append(path)
#                 return
#             if remaining_target < 0 or index == len(candidates):
#                 return
            
#             # logic
#             notchoose = helper(candidates,index + 1,remaining_target, path.copy())
#             temp = path.copy()
#             temp.append(candidates[index])
#             choose = helper(candidates,index,remaining_target - candidates[index], temp)
            
#         helper(candidates,0,target,[])
#         return self.result
        
        # method 2
#         self.result = []
#         def helper(candidates,index,remaining_target,path):
#             # base
#             if remaining_target == 0:
#                 self.result.append(path.copy())
#                 return
#             if remaining_target < 0 or index == len(candidates):
#                 return
            
#             # logic
#             notchoose = helper(candidates,index + 1,remaining_target, path)
#             path.append(candidates[index])
#             choose = helper(candidates,index,remaining_target - candidates[index], path)
#             path.pop()
            
#         helper(candidates,0,target,[])
#         return self.result

        # method 3
        self.result = []
        def helper(candidates,index,remaining_target,path):
            # base
            if remaining_target == 0:
                self.result.append(path.copy())
                return
            if remaining_target < 0 or index == len(candidates):
                return
            for i in range(index,len(candidates)):
                temp = path.copy()
                temp.append(candidates[i])
                helper(candidates,i,remaining_target -candidates[i],temp)
        helper(candidates,0,target,[])
        return self.result
