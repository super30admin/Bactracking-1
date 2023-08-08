class Solution:
    global outputList
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.outputList=[]
        li=[]
        self.helper(candidates, 0,target,li)
        return self.outputList

    def helper(self,candidates,i, target, path):
        #base
        if target<0 or i==len(candidates):
            return
        if target==0:
            self.outputList.append(path[::])
            return
        #Logic
        #Not choose
        self.helper(candidates,i+1, target, path)
        #Choose
        path.append(candidates[i])
        self.helper(candidates,i, target-candidates[i], path)
        path.pop()