# // Time Complexity : O(2^T) where T is the target value
# // Space Complexity : O(T/M) where M is the minimal value among the candidates
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def combinationSum(self, candidates, target: int):
        res = []
        
        def dfs(i, cur, total):
            # base cases
            if total == target:
                # since we will modify the cur later in recursion, we use copy of the cur
                res.append(cur.copy()) 
                return
                
            if i>=len(candidates) or total > target:
                return 
            
            # add the cadidates[i] in the cur
            cur.append(candidates[i])
            
            # call dfs for choosing the ith element
            dfs(i, cur, total + candidates[i])
            
            cur.pop() # clear cur for next recursion
            
            # call dfs for not choosing ith element
            dfs(i+1, cur, total)
            
        # start dfs with zero th index and empty list 
        dfs(0, [], 0)
        
        return res