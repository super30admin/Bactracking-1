"""
Time complexity O(4^N)
Space complexity 0(N) in recursive stack and O(4^N) as we create new path string at each node
"""


class Solution_Rec:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.res=[]
        self.targ=target
        if num is None or len(num)==0:
            return self.res
        self.helper(num,"",0,0,0)
        return self.res
    
    def helper(self,num,path,calc,tail,index):
        
        #base
        if(index==len(num)):
            if(calc==self.targ):
                self.res.append(path)
            return

        #logic
        for i in range(index,len(num)):
            str1=num[index:i+1]
            curr=int(str1)
            #preceding zero case 
            if(index != i and num[index]=='0'):
                break
            if(index==0):
                self.helper(num,path+str1,curr,curr,i+1)
            else:
                #+
                self.helper(num,path+"+"+str1,calc+curr,+curr,i+1)
                
                #'-'
                self.helper(num,path+"-"+str1,calc-curr,-curr,i+1)
                #'*'
                self.helper(num,path+"*"+str1,calc-tail+tail*curr,tail*curr,i+1)
        
            
        