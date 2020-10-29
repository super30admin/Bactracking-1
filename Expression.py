"""
Time - O(N ^ ((Target / Minimum) + 1))
Space - O(N ^ ((Target / Minimum) + 1))
Leetcode - Yes
Problems - No
"""
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        if not num:
            return []
			
        num_len = len(num)
        res = []
        
        def dfs(idx, path):
            if idx == num_len - 1:
                # num_len - 1 to prevent situations like (1+2+) or (1*3*) etc..
                path += num[idx] 
                if eval(path) == target:
                    res.append(path)
                return
            
            dfs(idx+1, path + num[idx] + "+") 
            dfs(idx+1, path + num[idx] + "-")
            dfs(idx+1, path + num[idx] + "*")
            if (path and path[-1] not in ['+', '-', '*'] and num[idx] == '0') or num[idx] != '0':
                
                # Prevent cases such as (2+05) which cannot be evaluated using the eval function
                # Cases such as 12+104 should be acceptable, but not 121+04
                
                dfs(idx+1, path + num[idx])
            
        dfs(0, "")
        return res
    