class Solution:
    global outputList
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.outputList=[]
        li=[]
        self.helper(candidates, 0,target,li)
        return self.outputList

    def helper(self,candidates,pivot, target, path):
        #base
        if target<0:
            return
        if target==0:
            self.outputList.append(path[::])
            return
        #Logic
        for i in range(pivot, len(candidates)):
            path.append(candidates[i])
            self.helper(candidates,i, target-candidates[i], path)
            path.pop()