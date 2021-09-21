# // Time Complexity :exponential
# // Space Complexity :exponential
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach





import copy
class Solution:
    def __init__(self):
        self.result=[]
        
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.helper(candidates,0,target,[])
        return self.result
    def helper(self,candidates,index,target,path):
        #base
        if target==0:
            print(path)
            li=copy.copy(path)
            self.result.append(li)
            
        if target<0:
            return
        #logic
        for i in range(index,len(candidates)):
            path.append(candidates[i])
            self.helper(candidates,i,target-candidates[i],path)
            path.remove(path[-1])
        