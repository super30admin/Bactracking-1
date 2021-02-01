#Time Complexity :o(2^n)
#Space Complexity :o(n)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no
class Solution(object):
    ans=None
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        if(candidates==None or len(candidates)==0 ):
            return []
        
        self.ans=[]
        self.backtrack(candidates, target,0,[])
        return self.ans
    
    
    def backtrack(self,candidates, target,index,path):
        #base
        if(target==0):
            self.ans.append(copy.deepcopy(path))
            return
        if(target<0 or index==len(candidates)):
            return
        
        #logic
        for i in range(index,len(candidates)):
            path.append(candidates[i])
            self.backtrack(candidates, target-candidates[i],i,path)
            path.pop()
        
        
    
#     def helper(self,candidates, target,index,path):
#         #base
#         if(target==0):
#             self.ans.append(copy.deepcopy(path))
#             return
#         if(target<0 or index==len(candidates)):
#             return 
        
#         #logic
#         #no Choose
#         self.helper(candidates, target,index+1,path)
#         #choose
#         path.append(candidates[index])
#         self.helper(candidates, target-candidates[index],index,path)
#         #backtrack
#         path.pop()
        
        
        