# Time Complexity : O(N x 2^N) because for each number we have 2 choice of adding or adding the current index and we will have to make a copy of an array, N is the number of elements needed for adding towards target.
#  Space Complexity : O(N) due to copy of array size N, N is the number of elements needed for adding towards target.
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

#  Your code here along with comments explaining your approach
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        subset = []
        
        def backtracking(index):
        #Base case: if the current index if out of bound or the total of the current subset is larger than the target. 
	    #Check the (sum(subset) > target), to prevent recursion call stack from overflowing.
            if index == len(candidates) or sum(subset) > target:  
            #If the total of current subset is the target, then add its copy to the result
                
                if sum(subset) == target:
                    res.append(subset.copy())
                return
            
            #Decision to add the current index number
            subset.append(candidates[index])
            backtracking(index)
            
            #Decision to not adding that number and consider to the next one
            subset.pop()
            backtracking(index + 1)
        #Call backtracking
        backtracking(0)
        
        return res
