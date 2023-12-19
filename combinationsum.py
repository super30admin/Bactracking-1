import copy
class Solution:
    res=[]
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        temp=[]
        self.res=[]
        self.helper(candidates,0,target,temp)
        
        return self.res

    def helper(self,candidates,i,target,path):
        if i == len(candidates) or target<0:
            return

        if target==0:
            self.res.append(copy.deepcopy(path))
            return


        self.helper(candidates,i+1,target,path)


        path.append(candidates[i])
        self.helper(candidates,i,target-candidates[i],path)
        path.pop()



