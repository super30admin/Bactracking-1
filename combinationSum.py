#Time Complexity: O(2**(target/min)+n)

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result= []
        self.path=[]
        if candidates==None or len(candidates)==0:
            return self.result
        self.helper(candidates, target, 0, [])
        return self.result
    def helper(self, candidates, target, i, path):
        if target==0:
            self.result.append(path[:])
            return
        if i==len(candidates) or target<0:
            return 
        
        #No choose
        self.helper(candidates, target, i+1, path)
        
        #Choose
        path.append(candidates[i])
        self.helper(candidates, target-candidates[i], i, path)
        #Backtracking
        path.pop()