# Time Complexity : O(N^(T/M) + 1)
# Space Complexity : O(T/M)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : 
# Your code here along with comments explaining your approach
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        output = []
        candidates.sort()
        
        def backtrack(currSum, out, index):
            if currSum > target:
                return 
            if currSum == target:
                output.append(list(out))
                return
            
            for i in range(index, len(candidates)):
                val = candidates[i]
                out.append(val)
                backtrack(currSum + val, out, i)
                out.pop()
        
        backtrack(0, [], 0)
        return output
