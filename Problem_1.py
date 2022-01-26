# // Time Complexity : Confused about it
# // Space Complexity : Confused Still
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : Followed approach from class but have to watch the class again for better understanding 
# // Your code here along with comments explaining your approach
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        
        #helper function
        def dfs(i, cur, total):
            if total == target:
                res.append(cur.copy())
                return
            if i>=len(candidates) or total>target:
                return
            cur.append(candidates[i])
            dfs(i,cur,total+candidates[i])
            cur.pop()
            dfs(i+1,cur,total)
            
        dfs(0,[],0)
        return res
        