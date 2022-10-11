"""
FAANMG Problem #70 {Hard}

282. Expression Add Operators

Time complexity : O(4 ^n)
                 4 - 1(+), 1(-), 1(*), 1(no op)
Space complexity : O(n * 4 ^ n)


Did this code successfully run on Leetcode : Yes

Recursive Solution 

@name: Rahul Govindkumar_RN27JUL2022
"""                
      

class Solution:
    
    
    def helper(self, num, pivot, calc, tail, path, target):
        
        #base
        if pivot == len(num):
            if calc == target:
                self.result.append(path)
            return
        
        #logic
        
        
        #create currenet numbers
        
        for i in range(pivot,len(num)):
            
            # preceeding zero
            if num[pivot] == "0" and pivot!=i:
                continue

            curr =int(num[pivot:i+1])
            
            if( pivot ==0):
                self.helper(num, i+1 , curr ,curr,  path + str(curr), target ) 
            
            else:
                #+
                self.helper(num, i+1, calc + curr , + curr , path +"+"+ str(curr), target)
                # -
                self.helper(num, i+1, calc - curr , - curr , path +"-"+ str(curr), target)
                #*
                self.helper(num, i+1, (calc - tail) +(tail * curr) , tail * curr , path +"*"+ str(curr), target)
               
                
        
        
        
        
    def addOperators(self, num: str, target: int) -> List[str]:
        
        self.result=[]
        
        self.helper(num, 0, 0, 0, "", target)
        
        return self.result
        