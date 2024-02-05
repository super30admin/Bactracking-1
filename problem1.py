#Time Complexity : O(2^T), where T is the target value.
#Space Complexity :O(T + 2^T)
#Did this code successfully run on Leetcode : yes

from ast import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []

        def dfs(i, curr, total):
            if total == target:
                result.append(curr[:])  
                return
            
            if i == len(candidates) or total > target: 
                return
            
            # Include the current candidate
            curr.append(candidates[i])
            dfs(i, curr, total + candidates[i])

            # Exclude the current candidate and move to the next one
            curr.pop()
            dfs(i + 1, curr, total)

        dfs(0, [], 0)
        return result