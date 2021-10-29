# Time Complexity : O(n^n) exponential
# Space Complexity : O(n^2) for recursion as we make new list at every node, O(n) for backtracking
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

# normal recursion: choose or not choose case like coin change
# normal backtracking: add to path, recursion, backtrack(remove from path)
# for loop recursion: index onwards, add element to new list and do recursion
# for loop backtracking: index onwards, add to path, recursion i onwards, backtrack(remove from path)


class Solution:

    # FOR LOOP BASED BACKRTRACKING
    def combinationSum(self, candidates, target: int):
        
        
        result = []
        if len(candidates) == 0 or candidates is None:
            return result
        
        def helper(candidates, index, target, path):

            nonlocal result

            if target == 0:
                result.append(path.copy())
                return

            if target < 0 or index == len(candidates):
                return

            for i in range(index, len(candidates)):
                
               
                path.append(candidates[i])
                helper(candidates, i, target - candidates[i], path)
                path.pop()
                

        helper(candidates, 0, target, [])
        return result



    # FOR LOOP BASED RECURSION
    # def combinationSum(self, candidates, target: int):
        
        
    #     result = []
    #     if len(candidates) == 0 or candidates is None:
    #         return result
        
    #     def helper(candidates, index, target, path):

    #         nonlocal result

    #         if target == 0:
    #             result.append(path)
    #             return

    #         if target < 0 or index == len(candidates):
    #             return

    #         for i in range(index, len(candidates)):
                
    #             newli = path.copy()
    #             newli.append(candidates[i])
    #             helper(candidates, i, target - candidates[i], newli)
                

    #     helper(candidates, 0, target, [])
    #     return result


    # NORMAL BACKTRACKING
    # def combinationSum(self, candidates, target):

    #     result = []
    #     if len(candidates) == 0 or candidates is None:
    #         return result
        
    #     def helper(candidates, index, target, path):

    #         nonlocal result

    #         if target == 0:
    #             result.append(path.copy())
    #             return

    #         if target < 0 or index == len(candidates):
    #             return

    #         # not choose
    #         helper(candidates, index + 1, target, path)

    #         path.append(candidates[index])
    #         # choose
    #         helper(candidates, index, target - candidates[index], path)

    #         path.pop()

    #     helper(candidates, 0, target, [])
    #     return result 


    # NORMAL RECUSRSION
    # def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
    #     result = []
    #     if len(candidates) == 0 or candidates is None:
    #         return result
        
    #     def helper(candidates, index, target, path):

    #         nonlocal result

    #         if target == 0:
    #             result.append(path)
    #             return

    #         if target < 0 or index == len(candidates):
    #             return

    #         # not choose
    #         helper(candidates, index+1, target, path.copy())
            
    #         path.append(candidates[index])
    #         helper(candidates, index, target - candidates[index], path.copy())

    #     helper(candidates, 0, target, [])
    #     return result