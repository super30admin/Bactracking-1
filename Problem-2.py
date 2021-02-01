#Time Complexity :O(4^n)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : No
class Solution(object):
    res=None
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        if(len(num)==0 or num==None):
            return []
        
        self.res=[]
        self.helper(num,target,0,0,0,"")
        return self.res
    
    def helper(self,num,target,calc,tail,index,string):
        #base
        if(index==len(num)):
            if(target==calc):
                self.res.append(string)
            return 
        
        #logic
        for i in range(index,len(num)):
            
            curr=int(num[index:i+1])
            if(i!=index and num[index]==0):
                continue
           
            if(index==0):
                self.helper(num,target,curr,curr,i+1,string+str(curr))
            else:
                #+
                self.helper(num,target,curr+calc,curr,i+1,string+'+'+str(curr))
                #-
                self.helper(num,target,curr-calc,-curr,i+1,string+'-'+str(curr))
                #*
                self.helper(num,target,calc-tail+(tail*curr),tail*curr,i+1,string+'*'+str(curr))
                
                