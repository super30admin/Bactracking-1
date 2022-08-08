"""
Runtime Complexity: Exponentital
Space Complexity: Exponential
Yes, the code worked on leetcode
The runtime and space complexity depends on the length of the string.
Issues while coding - No
"""

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        if not num:
            return []
        self.result = []
        self.helper(num,target,0,"",0,0)
        return self.result
    
    def helper(self,num,target,index,path,calc,tail):
        if index == len(num):
            if calc == target:
                self.result.append(path)
            return 
       
        for i in range(index,len(num)):
            if index!=i and num[index]=='0':
                continue
            
            curr = num[index:i+1]
            int_curr = int(curr)
            int_calc = int(calc)
            int_tail = int(tail)
            
            if index ==0:
                self.helper(num,target,i+1, path+ curr,int_curr,int_curr)
            
            else:
                self.helper(num,target,i+1,path+"+"+curr,int_calc+int_curr,int_curr)
                self.helper(num,target,i+1,path+"-"+curr,int_calc-int_curr,-int_curr)
                self.helper(num,target,i+1,path+"*"+curr,(int_calc-int_tail)+(int_tail*int_curr),int_tail*int_curr)
                