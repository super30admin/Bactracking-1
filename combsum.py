class Solution:
    def findCombination(self, i, target, arr, ans, ds):
        if i== len(arr):
            if target == 0:
                ans.append(ds.copy())
                
            return
        
        if arr[i] <= target:
            ds.append(arr[i])
            self.findCombination(i,target - arr[i], arr, ans, ds)
            ds.pop()
            
        self.findCombination(i+1, target, arr, ans, ds)
        
        
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        ans = []
        ds = []
        self.findCombination(0, target, candidates, ans, ds)
        
        return ans
        
