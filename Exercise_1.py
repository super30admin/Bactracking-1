# Time Complexity: O(n^((t/m)+1))
# Space Complexity: O(t/m)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No


class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        #for loop based backtracking
        result = []
        if candidates == None or len(candidates)==0:
            return result
        
        def helper(index, target, path):
            if target == 0:
                result.append(list(path))
                
            if target<0:
                return
            
            for i in range(index, len(candidates)):
                path.append(candidates[i])
                helper(i, target-candidates[i], path)
                path.pop()
            
        helper(0, target, [])
        return result
            
#recursive solution
#         result = []
#         if candidates == None or len(candidates)==0:
#             return result
        
#         def helper(index, target, path):
#             if target == 0:
#                 return result.append(path)
#             if target<0 or index==len(candidates):
#                 return
#             #do not choose the element
#             helper(index+1, target, list(path))
#             #choose
#             path.append(candidates[index])
#             helper(index, target-candidates[index], list(path))
            
#         helper(0, target, [])
        
#         return result     