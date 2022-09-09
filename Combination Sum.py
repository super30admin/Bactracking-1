# TC : O(2 ^ ((t/min)+n))
# SC : O((t/min)+n)
class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        self.count=0
        self.result=[]
        self.candidates = candidates
        self.backtrack(target,0,[])
        print(self.count)
        return self.result
        
    def backtrack(self,target,i,path):
        self.count+=1
        #base
        if (target==0):
            self.result.append(path[:])
            return
        
        if(target<0 or i==len(self.candidates)):
            return
        
        
        #logic  
        #nochoose
        self.backtrack(target,i+1,path)
        
        #action
        path.append(self.candidates[i])
        
        #recurse
        #choose
        self.backtrack(target-self.candidates[i],i,path)
        
        #backtrack
        path.pop()