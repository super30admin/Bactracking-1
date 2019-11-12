# Leet code- Combination Sum- 39 - https://leetcode.com/problems/combination-sum/
#Time complexity - (2^N)
#space complexity 
# Approach - Backtracking- In Backtracking we process from bottom onwards, while in DFS we process from top onwards. 



class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        res=[]
        curr_list=[]
        index=0
        if len(candidates)==0: return res
        return self.backtrack(candidates,target,curr_list,res,index)
    
    def backtrack(self,candidates,target,curr_list,res,index):
        
            #base case
            if target==0:
                res.append(curr_list)
                return res
            if target<0:
                curr_list.pop()
        
            #logic
            size=len(candidates)
            for i in range(size):
                if candidates[i]<=target:
                    self.backtrack(candidates[i:],target-candidates[i],curr_list+[candidates[i]],res,i)
                
            return res
        
        
    class Solution(object):
    def combinationSum(self, candidates, target):
        
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        res=[]
        path=[]
        index=0
        if len(candidates)==0: return []
        self.backtrack(candidates,target,res,path,index)
        return res
        
    
    def backtrack(self,candidates,target,res,path,index):
        
            #base case
            if target==0:
                res.append(path[:])
                return res
            if target<0: return
        
            #logic
            for i in range(index,len(candidates)):
                if candidates[i]<=target:
                    path.append(candidates[i])
                    print("before",path)
                    self.backtrack(candidates,target-candidates[i],res,path,i)
                    path.pop()
                    print("after",path)
        
            
            
