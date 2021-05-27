# TC: O(2^N) since we are exploring 2 options from pivot to end of array about valid path by considering each element or not considering. 
# SC: O(H) where H is the height of the recursive tree.

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        if not candidates or len(candidates) == 0:
            return
        
        def backtrack(pivot, target, path):
#             base
            if target == 0:
                self.result.append(path.copy())
                return
            
            if target < 0:
                return
            
            for i in range(pivot, len(candidates)):
#               action
                path.append(candidates[i])
#               recurse
                backtrack(i, target - candidates[i], path)
#               backtrack
                path.pop()

        backtrack(0, target, [])
        return self.result    
        
