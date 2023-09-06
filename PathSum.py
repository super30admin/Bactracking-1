class Solution:
    def __init__(self):
        self.result = []
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        path = []
        self.helper(candidates,target,0,path)
        return self.result
    
    def helper(self,candidates,target,index,path):
        # base cond
        if index == len(candidates) or target < 0:
            return
        if target == 0:

            self.result.append(path[:])
            return

        # not choose

        self.helper(candidates,target,index+1,path)

        # choose
        path.append(candidates[index])
        self.helper(candidates,target-candidates[index],index,path)
        path.pop()
        



        