"""
Time complexity O(4^N)
Space complexity 0(N)  


As python does not have a Mutable string like string builder used list for the path and did action, recurse and backtrack


"""

class Solution_Backtrack:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.res=[]
        self.targ=target
        if num is None or len(num)==0:
            return self.res
        path=[]
        self.helper(num,path,0,0,0)
        return self.res
    
    def helper(self,num,path,calc,tail,index):
        
        #base
        if(index==len(num)):
            if(calc==self.targ):
                self.res.append("".join(path))
            return

        #logic
        for i in range(index,len(num)):
            str1=num[index:i+1]
            curr=int(str1)
            #preceding zero case 
            if(index != i and num[index]=='0'):
                break
            if(index==0): #NO-OP
                path.append(str1) #a
                self.helper(num,path,curr,curr,i+1)#r
                path.pop()#b
            else:
                #+
                print("path",path)
                path.append('+') #action
                path.append(str1) #action
                self.helper(num,path,calc+curr,+curr,i+1) #recurse
                path.pop()#backtrack
                path.pop() #backtrack
                #'-'
                path.append('-')
                path.append(str1)
                self.helper(num,path,calc-curr,-curr,i+1)
                path.pop()
                path.pop()
                #'*'
                path.append('*')
                path.append(str1)
                self.helper(num,path,calc-tail+tail*curr,tail*curr,i+1)
                path.pop()
                path.pop()
        
            
        