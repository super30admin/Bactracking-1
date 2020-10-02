# Time Complexity - O(N!)
# Space Complexity - O(N)
class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        result = []
        self.backtrack(candidates, target, result, 0, [])
        return result
        
    def backtrack(self, candidates, target, result, index, currentList):
        if target < 0:
            return
        elif target == 0:
            result.append(list(currentList))
            return 
        for i in range(index,len(candidates)):
            currentList.append(candidates[i])
            self.backtrack(candidates, target-candidates[i],result,i, currentList)
            currentList.pop(-1)
        
            
        