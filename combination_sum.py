
# Time Complexity : Add - O(n*2^n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. start with a pivot element and start adding elements recursively to a list
2. Also update the remaining sum recursively.
3. Backtrack and undo the changes. The recusrion add the list of elements to a global result when rem sum == 0

'''

class Solution:
    result = []
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        self.result = []
        
        if candidates == [] or len(candidates) < 0:
            return 
        
        self._backtrack(candidates, target, target, 0, []) 
        return self.result
        
        
        
    def _backtrack(self, candidates, target, cur_sum, index, list_):
        
        if cur_sum == 0:
            self.result.append(list_[:])
            return
        
        if cur_sum < 0:
            return
            
        for i in range(index, len(candidates)):
            
            list_.append(candidates[i])
            self._backtrack(candidates, target, cur_sum-candidates[i], i, list_)
            _ = list_.pop()
        