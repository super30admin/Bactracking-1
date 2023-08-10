#Time Complexity :O(n)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result=[]
        self.helper(candidates,0,target,[])
        return self.result

    def helper(self,candidates,pivot,target,path):
        if target<0 or pivot==len(candidates):
            return 
        if target==0:
            self.result.append(path)
            return

        #for i in range(pivot,len(candidates)):
        #    path.append(candidates[i])
        #    self.helper(candidates,i,target-candidates[i],path)
        #    del(path[-1])

        index=pivot

        #choose
        path.append(candidates[index])
        self.helper(candidates,index,target-candidates[index],list(path))
        del(path[-1])
        #not choose
        self.helper(candidates,index+1,target,list(path))

        