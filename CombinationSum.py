# Time Complexity : N ^ ((Target / Minimum) - 1 )
''' Imagine a tree for this solution.
    How many children can each node have? Upper bounded by N, right? Okay, let this be equation 1.
    Were is the maximum depth? Repeated use of the smallest element in the candidates takes 
    the most steps to find out if there is a solution or not. 
    How many steps? Target / Minimum steps. Hence, depth = Target / Minimum, let this be equation 2.

    In a binary tree (number of children = 2) of height H, the number of nodes is 2 ^(H - 1)
    Hence, from equation 1 and 2.
    Number of Nodes in this tree = N ^ ((Target / Minimum) - 1 )
'''
# Space Complexity : (Target / Minimum) stack size is the deepest depth. See equation 2.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []
        def recur(target, pos, combi):
            nonlocal result
            if target == 0:
                result.append(combi)
                return
            if target < 0:
                return
            for i in range(pos, len(candidates)):
                recur(target - candidates[i], i, combi + [candidates[i]])
        recur(target, 0, [])
        return result