#Time Complexity O(N^2)
#Space Complexity O(N^2)
class Solution:
    def __init__(self):
        self.result = []
        
    def helper(self,candidates,index,path,target):
        #Base Case
        if target ==0:
            self.result.append(path)
            return None
        if target < 0 or index == len(candidates):
            return None
        newpath = list(path)
        
        #Choose 
        self.helper(candidates,index+1,newpath,target)
        
        #Choose Not
        # temp = list(path)
        # temp.append(candidates[index])
        # self.helper(candidates,index,temp,target-candidates[index])
        
        #Backtracking
        # temp = list(path)
        path.append(candidates[index])
        self.helper(candidates,index,path,target-candidates[index])
        
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.helper(candidates,0,list(),target)
        return self.result
        
        
