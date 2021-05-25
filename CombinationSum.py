"""39. Combination Sum
Time Complexity - O(2^mn)
Space Complexity - O(n) -> Height of tree

Approach -> backtracking"""

class Solution:
    def __init__(self):
        self.result = []
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if candidates == None or len(candidates)==0:
            return self.result
        path = []
        
        self.backtrack(candidates,target,path,0)
        return self.result
    
    def backtrack(self,candidates,target,path,index):
        #base
        if target<0:
            return
        elif target == 0:
            self.result.append(list(path))
            return
        
        
        for i in range(index, len(candidates)):
            #action
            path.append(candidates[i])
            #recursive
            self.backtrack(candidates,target-candidates[i],path,i)
            #backtrack
            path.pop(len(path)-1)
        
        