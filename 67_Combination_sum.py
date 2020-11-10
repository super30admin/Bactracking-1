'''
S30 Big N Problem #67 {Medium}

LC - 39. 
Combination Sum
 

 Time Complexity : O(n^n) n=length of string
 Space Complexity : O(n) n=length of string
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No 

 Approach
 Start from 0th index of the string. Generate the various combinations using recursion. 
 Check the sum is equal to target
'''

class Solution:
    res=[]
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.res=[]
        
        temp=[]
        
        self.helper(candidates,target,0,temp)
        return self.res
        
    
    def helper(self,arr,target,index,temp):
        
        if temp is not None and sum(temp)==target:
            self.res.append(temp)
        
        if temp is not None and sum(temp)>target:
            return 
            
        for i in range(index,len(arr),1):
            self.helper(arr,target,i,temp+[arr[i]])
        
        
        