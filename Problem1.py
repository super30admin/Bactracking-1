class Solution:
    
    """
    
        Student : Shahreen Shahjahan Psyche
        Time : O(N*2^N)
        Space : O(N)
        
        Passed All Cases in LC: Yes
        
    
    """
    
    def helper(self, candidates: List[int], target: int, index : int, result: List[List[int]], track: List[int], sum_val : int) -> None:
        
        # base case
        if sum_val > target or index == len(candidates):
            return
        if sum_val == target:
            result.append(list(track))
            return
        
        for i in range(index, len(candidates)):
            # action
            track.append(candidates[i])
            # recurse
            self.helper(candidates, target, i, result, track, sum_val + candidates[i])
            # backtrack
            track.pop()
            
    
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        result = []
        track = []
        index = 0
        sum_val = 0
        
        self.helper(candidates, target, index, result, track, sum_val)
        
        return result
        
        
        
