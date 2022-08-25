# Time Complexity: O(N^T/M), where N is len(candidates), T is target,and M is min value in candidates.
# Space Complexity: O(T/M)

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []
        
        def helper(candidates, idx, amount, path):
            if amount<0:
                return
            if amount==0:
                result.append(list(path))
                return
            
            for i in range(idx,len(candidates)):
                # Action
                path.append(candidates[i])
                # Recurse
                helper(candidates,i, amount-candidates[i],path)
                # Backtrack
                path.pop()
        
        helper(candidates,0,target,collections.deque())
        # Giving empty deque instead of list as 
        return result