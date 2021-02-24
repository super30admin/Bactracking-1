// Time Complexity : O(O(n^n))
// Space Complexity : O(depth of recursive tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        path=[]
        self.output=[]
        if not candidates or len(candidates)==0:
            return output
        
        self.backtracking(candidates,0,target,path) //call recursive function
        return self.output
        
        
    
    def backtracking(self,candidates,index,target,path):
        if target<0:    #if target is negative simply return
            return 
        
        if target==0:   //if taget ==0 => append the path list in the output list 
            self.output.append(list(path))
            return
        
        for i in range(index,len(candidates)):  traverse the elements from  current index till last and append the element and call the same function again with the same index till the target>=0 
            path.append(candidates[i])
            self.backtracking(candidates,i,target-candidates[i],path)
            path.pop()
