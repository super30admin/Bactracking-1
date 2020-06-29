---------------------------------- Combination Sum Backtrack -------------------------------------
# Time Complexity : O(2^N) N is the length of the s
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here I have used backtracking solution where I choose a number or not choose a number by iterating through it.
#Here I choose the number and explore all the choices by calling recurse function. and when I finishes recursing, I am poping the number from my temp array.
# Action, recurse and backtrack.


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if not candidates:
            return []
        
        def recursive(candidates, curr,temp, index, target):
            #base
            
            if curr == target:
                res.append(list(temp))
                return
            
            if curr>target:
                return 
            
            for i in range(index,len(candidates)):
                temp.append(candidates[i])
                recursive(candidates, curr+candidates[i],temp, i, target)
                temp.pop()
            
        res = []
        recursive(candidates, 0, [], 0, target)
        return res
        
        
---------------------------------- Combination Sum Recursive -------------------------------------
# Time Complexity : O(2^N) N is the length of the s
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here I have used recursive solution where I choose a number or not choose a number by iterating through it.
#Here I choose the number and explore all the choices by calling recurse function. and when I finishes reach my target, I am appending new list to the result array.
#and poping the element from the list.

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if not candidates:
            return []
        
        def recursive(candidates, curr,temp, index, target):
            #base
            
            if curr == target:
                res.append(list(temp))
                return
            
            if curr>target or index>= len(candidates):
                return 
            
            #logic
            recursive(candidates, curr,temp, index+1, target )
            
            temp.append(candidates[index])
            recursive(candidates, curr+candidates[index],temp, index, target)
            temp.pop()
            
        res = []
        recursive(candidates, 0, [], 0, target)
        return res