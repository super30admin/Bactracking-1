#TC: O(2^(target/minimum denomination)) since we can choose each number any number of times until we meet target, thus it would be target/minimum denomination as minimum denomination will have highest choices
#SC: O(length of longest combination)

class Solution:
       
    def backtrackCombinationSum(self, candidates, index, target, curr, result):
        #base case
        if target == 0:
            result.append(curr)
            return
        
        if target < 0 or index == len(candidates):
            return
        
        for i in range(index, len(candidates)):
            self.backtrackCombinationSum(candidates,i, target-candidates[i] , curr+[candidates[i]], result)
        
        
        
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = [] #will contain list result
        curr = [] #will contain the numbers selected
        candidates.sort()
        self.backtrackCombinationSum(candidates, 0, target, curr, result)
        return result    