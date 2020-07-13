import copy
class Solution:
    def __init__(self):
        self.target=None
        self.result=[]
    def addOperators(self, num: str, target: int) -> List[str]:
        self.target=target
        if num==None or len(num)==0:
            return result
        self.helper(num,"",0,0,0)
        return self.result
    def helper(self,num,path,calc,tail,index):
        #base
        if index==len(num):
            if self.target==calc:
                self.result.append(path)
        
        for i in range(index,len(num)):
            if num[index]=='0' and index!=i:
                break
            curr=int(num[index:i+1])
            if index==0:
                self.helper(num,path+str(curr),curr,curr,i+1)
            else:
                self.helper(num,path+"+"+str(curr),calc+curr,curr,i+1)
                
                self.helper(num,path+"-"+str(curr),calc-curr,-curr,i+1)
                
                self.helper(num,path+"*"+str(curr),calc-curr+tail*curr,tail*curr,i+1)
                
 Space complexity is O(2 raise to n)
 Time is O(n*2*n)
