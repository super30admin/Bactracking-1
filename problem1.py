# Time Complexity : O(n), 
# Space Complexity : o(n)

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 

# Your code here along with comments explaining your approach



def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:

    dp = [[] for i in range(target + 1)]
    dp[0] = [[]]
    
    for c in candidates:
        for i in range(c, target + 1):
            for path in dp[i-c]:
                dp[i].append(path + [c])
    
    return dp[-1]