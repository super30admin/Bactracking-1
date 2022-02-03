#Time Complexity = O(2^n)
#Space Complexity = O(n)

class Solution:
    path = []
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.path = []
        self.helper(candidates,target,0,0,[])
        return self.path
        
    def helper(self,candidates,target,curr,index,path):
        if(index==len(candidates) or curr>target):
            return 
        if(curr==target):
            self.path.append([i for i in path])
            return 
        self.helper(candidates,target,curr,index+1,path)
        path.append(candidates[index])
        self.helper(candidates,target,curr+candidates[index],index,path)
        path.pop()
        
        