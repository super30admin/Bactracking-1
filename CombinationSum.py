'''
time complexity: O(exponential)
space complexity: O(exponential)
'''
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if(len(candidates)==0 or target==0): return []
        self.results = []
        self.helper(candidates,target,0,[])
        return self.results
    def helper(self,candidates,target,index,ls):
        if(target==0):
            self.results.append(list(ls))
            return
        if(target<0 or index==len(candidates)): return

        self.helper(candidates,target,index+1,ls)
        ls.append(candidates[index])
        
        self.helper(candidates,target-candidates[index],index,ls)
        
        ls.pop()