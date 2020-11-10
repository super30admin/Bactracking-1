'''
S30 Big N Problem #68 {Hard}

LC - 282. 
Expression Add Operators

 Time Complexity : O(n^n) n=length of string
 Space Complexity : O(n) n=length of string
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No 

 Approach
 
 1. generate various combinations of given string.
 2. include +,-,* operators in between and calculate value of the expression
 3. Handle the cases of BODMAS
 4. Handle the case when 0 is present in the string
'''

class Solution:
    
    ops=('+','-','*')
    res=[]
    def addOperators(self, num: str, target: int) -> List[str]:
        self.res=[]
        
        self.helper(num,0,target,"",0,0)
        return self.res
        
    
    def helper(self,num,index,target,temp,tempval,prev):
        
        if index>=len(num) and tempval==target:
            self.res.append(temp)
            return 
         
        
        for i in range(index,len(num)):
            
            if num[index]=='0' and index!=i:
                continue
            
            curr=int(num[index:i+1])
            
            if index ==0:
                self.helper(num,i+1,target,temp+str(curr),curr,curr)
            else:
                self.helper(num,i+1,target,temp+'*'+str(curr),tempval-prev+prev*curr,curr*prev)
                self.helper(num,i+1,target,temp+'+'+str(curr),tempval+curr,curr)
                
                self.helper(num,i+1,target,temp+'-'+str(curr),tempval-curr,-curr)
        
                
        
        
        
