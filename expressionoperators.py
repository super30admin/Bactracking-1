"""
#Leetcode: accepted
#time complexity: 4^n (n is the length of the string)
#Explaination: 
#doubt: 

"""

class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        result=[]
        if num==None or len(num)==0:
            return result
        self.helper("",0,result,num,target,0,0)
        return result
        
        
    def helper(self,path,index,result,num,target,calculated,tail):
        #base case
        if index==len(num):
            if calculated==target:
               result.append(path)
               return
        
        
        
        for i in range(index,len(num)):
            #take care of precedding 0
            if (i!=index and num[index]=='0'):
                break
            curr=int(num[index:i+1])
            if index==0:
                self.helper(path+str(curr),i+1,result,num,target,curr,curr)
                print(curr)
            else:
                self.helper(path + '+' + str(curr),i+1,result,num,target,calculated+curr,curr)
                print(calculated)
                self.helper(path + '-' + str(curr),i+1,result,num,target,calculated-curr,-curr)
                self.helper(path + '*' + str(curr),i+1,result,num,target,calculated-tail+ tail *curr,tail*curr)
                