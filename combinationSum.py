"""
https://leetcode.com/problems/combination-sum/
// Time Complexity: O(2 ^N)
// Space Complexity: O(N)
"""

def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]
    rtnData = []
    if candidates is None or len(candidates) == 0: return rtnData

    def dfs(i, curr, total):
        if total == target:
            rtnData.append(curr.copy())
            return
        if i >= len(candidates) or total > target:
            return

        curr.append(candidates[i])
        # add candidates
        dfs(i, curr, total + candidates[i])
        curr.pop()
        # do not candidates
        dfs(i + 1, curr, total)

    dfs(0, [], 0)
    return rtnData