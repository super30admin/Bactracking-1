'''
time complexity: O(exponential)
space complexity: O(len(num))
'''
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        if(len(num)==0): return []
        self.results=[]
        self.helper(num,target,0,0,0,"")
        return self.results
    def helper(self,num,target,calc,tail,idx,path):
        if(idx==len(num)):
            if(target==calc):
                self.results.append((path))
            return
        
        for i in range(idx,len(num)):
            curr = int(num[idx:i+1])
            if(num[idx]=='0' and i!=idx): continue
            if(idx==0):
                self.helper(num,target,curr,curr,i+1,path+str(curr))
            else:
                #+
                self.helper(num,target,calc+curr,curr,i+1,path+"+"+str(curr))
                #-
                self.helper(num,target,calc-curr,-curr,i+1,path+"-"+str(curr))
                #*
                self.helper(num,target,calc-tail+tail*curr,curr*tail,i+1,path+"*"+str(curr))
                
        