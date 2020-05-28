# Time COmplexity: O(l^k)
# Where l is the length of the array, k is the length of the longest possible combination (namely target / minInArray).
# i.e. If the min value in array is 1, and target is 9, the longest length of possible combination is 9 (9/1)

# Space Complexity: O(k)
# For storing the path, which could be k long at most.
# Ran successfully on Leetcode:yes
# Algorithm :
# 1. explore all the possible path to obtain the target by considering each element as pivot and traversing from that pivot in each substring.
# 2. When the index reaches end of the list or the sum of the elements in the list is greater than target, we return . 
# 3. Else if the sum of the elements on the list is equal to target, we return that result.

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        if not candidates or len(candidates)==0:
            return []
        result=[]
        self.backtrack(candidates, [],0,target,result)
        
        return result
    def backtrack(self,candidates,temp,index,target,result):
        # global targ
        # global result
      
        targ=target
        if sum(temp)==targ:
            result.append(temp)
        if  sum(temp)>targ or index==len(candidates):
            return 
        for i in range(index,len(candidates)):
            # temp.append(candidates[i])
            self.backtrack(candidates, temp+[candidates[i]],i,target,result)
            # temp.pop()
            
        
