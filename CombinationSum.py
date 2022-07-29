# Time Complexity => O(2^N)
# Space Complexity => O(N)

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []
        if(len(candidates)==0):
            return result
        path = []
        def helper(candidates, target, index, path):
            if(target<0 or index == len(candidates)):
                return
            if(target == 0):
                result.append(path.copy())
                return
            for i in range(index, len(candidates)):
                path.append(candidates[i])
                helper(candidates, target-candidates[i], i, path)
                path.pop()
        
        helper(candidates, target, 0, path)
        return result
        