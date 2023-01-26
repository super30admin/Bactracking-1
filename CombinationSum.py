#Time Complexity: Exponential
#Space Complexity: O(n)
#Successfully ran on leetcode

class Solution:
    def __init__(self):
        self.result = []
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if len(candidates)==0:
            return []
        self.helper(candidates,target,0,[])
        return self.result
    def helper(self,candidates,target,index,path):
        #base
        if target<0:
            return
        if target==0:
            self.result.append(copy.copy(path))
            return
        for i in range(index,len(candidates)):
            path.append(candidates[i])
            self.helper(candidates,target-candidates[i],i,path)
            path.pop()