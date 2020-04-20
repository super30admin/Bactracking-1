"""
// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
Algorithm explanation
The main idea is to have two decision for each recursive call, either to take
the number or not take it. 
When the target is reached, we add the result of current numbers list to final 
candidates list and backtrack by removing the elements off the stack (via result arry)
"""

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []
        final_candidates = []
        
        def comb_rec(candidates,i,target):
            if target == 0:
                # found the sum, update the final_candidates with current result array
                #result.append(candidates[i])
                final_candidates.append(result[::])
                return
            
            #base case - exhasuting the candidates array or if current element > target, cannot get the combination
            if i == len(candidates) or candidates[i] > target:
                return
            
            result.append(candidates[i])
            comb_rec(candidates,i,target-candidates[i])
            #Backtracking the result array as we cannot find the target beyond this point
            result.pop()
            comb_rec(candidates,i+1,target)
        
        #sorting the candidates to ensure the increasing order of elements
        candidates.sort()
        comb_rec(candidates,0,target)
        return final_candidates