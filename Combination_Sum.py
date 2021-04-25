class Solution:
    result = []
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        candidates.sort()
        self.helper_new(candidates,0,target,[])
        
        return Solution.result  
    
    def helper(self,candidates,index,target,path):
        
        #base
        if index == len(candidates) or target < 0:            
            return
        
 
        #logic
        if target == 0:
            Solution.result.append(path.copy()) 
            return
        
        #choose
        self.helper(candidates,index+1,target,path)
        #Action
        path.append(candidates[index])
        
        #recurse     
        #dontchoose
        self.helper(candidates,index,target-candidates[index],path)     
        #backtrack
        path.pop()
    
    def helper_new(self,candidates,index,target,path):
        
         #base
        if target < 0:            
            return
         
        #logic
        if target == 0:
            print(path)
            Solution.result.append(path.copy()) 
            return
        
        for i in range(index,len(candidates)):
            path.append(candidates[i])
            self.helper_new(candidates,i,target-candidates[i],path)     
            path.pop()
            
        
