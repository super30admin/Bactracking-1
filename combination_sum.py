class Solution:
    result = ""
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        self.helper(candidates , 0 , target , [])

        return self.result
    
    def helper(self,candidates ,i , target , path):

        #Base case
        if target < 0 or i == len(candidates):
            return

        if target == 0 :
            self.result.append(list(path))
            return
        #logic


        ## Case where we do not choose

        self.helper(candidates , i + 1 , target , path)

        ## Case where we choose element

        #action
        path.append(candidates[i])

        #recurse
        self.helper(candidates , i  , target - candidates[i],path )

        #backtrack
        path.pop(len(path) - 1) 
