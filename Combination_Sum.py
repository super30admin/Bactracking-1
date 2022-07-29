class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result=[]
        
        def combination_sum(start,target,path):
            if target<0:
                return
            
            if target==0:
                result.append(path[:])
                return
            
            for i in range(start,len(candidates)):
                path.append(candidates[i])
                combination_sum(i,target-candidates[i],path)
                path.pop()
            
        combination_sum(0,target,[])
        
        return result
        
        
            
        