#time: O(2^n)
#space: O(2^n)
#recursion
class Solution:
    result=[]
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if(candidates==None or len(candidates)==None):
            return  []
        self.result=[]
        self.helper(candidates,target,0,[],0)
        return self.result
    
    def helper(self,candidates,target,index,path,pathsum):

        if(index==len(candidates) or pathsum>target):
            pathsum=0
            return
        if(pathsum==target):
            newpath=[]+path
            self.result.append(newpath)
            pathsum=0
            return
        
        newpath=[]+path
        self.helper(candidates,target,index+1,newpath,pathsum)
        
        path.append(candidates[index])
        newpath=[]+path
        self.helper(candidates,target,index,newpath,pathsum+candidates[index])
        
        