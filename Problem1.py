"""
39. Combination Sum
Time Complexity - O(n**n)
Space Complexity - O(n) where n is max len of sum list i.e. path
Calling Recurssion function and passing list,target,output,index i.e. 0 initially and path list
if target is 0 append path to output
if target is less than 0 return to function
for loop from index to len(candidate)
append candidate value at index i to path and call recurssion with changing target = target- candidate[i] ,updated path and i value
pop last element from path
"""
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.output = []
        self.recurssion(candidates,target,self.output,0,[])
        return self.output
    
    def recurssion(self,candidates,target,output,index,path):
        if target < 0:
            return 
        if target == 0:
            output.append(path[:])
            return
        for i in range(index,len(candidates)):
            path.append(candidates[i])
            self.recurssion(candidates,target-candidates[i],output,i,path)
            path.pop()
        
        