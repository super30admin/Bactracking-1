'''
Time Complexity -->
O(2^n) Since we are either choosing the elemnt or not

Space Complexity -->
O(2^n)
'''
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        self.dfs(candidates, 0, target, [], res)
        return(res)
    
    
    def dfs(self,candidates, index, target, ans, res):
        if index>=len(candidates) or target<0:
            return
        if target ==0:
            res.append(ans[:])
            return
        #not choose
        self.dfs(candidates, index+1, target, ans, res)
        
        #choose
        ans.append(candidates[index])
        self.dfs(candidates, index, target-candidates[index], ans, res)
        ans.pop(-1)
        
        