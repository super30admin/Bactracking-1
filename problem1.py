


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if len(candidates) == 0:
            return
        self.result = []
        self.length = len(candidates)
        self.helper(candidates,target,0,[])
        return self.result

    def helper(self,candidates,target,index,path):
        if target == 0:
            self.result.append(list(path))
            return

        if target < 0:
            return

        for i in range(index,self.length,1):

            path.append(candidates[i])

            self.helper(candidates,target-candidates[i],i,path)

            path.pop()


        
