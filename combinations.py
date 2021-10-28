'''
Time: O(N^(T/M + 1)) where T is the target, M is the minimum element in the candidates
Space: O(T/M) or O(T)
'''
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        global output
        output=[]
        path=[]
        
        if candidates is None or len(candidates)==0:
            return output
        
        self.backtracking(candidates,target,path,0)
        return output
    
    def backtracking(self,candidates,target,path,index):
        if target<0:
            return 
        
        if target==0:
            output.append(list(path)) #Deep Copy 
            return
        
        #Backtracking
        for i in range(index,len(candidates)):
            path.append(candidates[i])
            self.backtracking(candidates,target-candidates[i],path,i)
            path.pop()
        