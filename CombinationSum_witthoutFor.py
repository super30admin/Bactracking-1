# TC: O(2^N) since for every candidate we are exploring 2 ways of either choosing it or not choosing it. 
# SC: O(H) where H is the height of the recursive tree.

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        if not candidates or len(candidates) == 0:
            return
        
        def backtrack(index, target, path):
#             base
            if target == 0:
                temp = []
                temp = path.copy()
                self.result.append(temp)
                return
            
            if target < 0 or index >= len(candidates):
                return

#               logic
#             dont choose
            backtrack(index + 1, target, path)
#           choose
#             Action
            path.append(candidates[index])
#               Recurse
            backtrack(index, target - candidates[index], path)
#               Backtrack
            path.pop()
        backtrack(0, target, [])
        return self.result 
