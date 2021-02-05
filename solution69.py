#Time Complexity:Exponential
#Space Complexity:Exponential

class Solution:
    global result                                                                   #declaring global variables
    global targ
    def addOperators(self, num: str, target: int) -> List[str]:
        self.result=[]                                                              #initializing result array to empty
        self.targ=target                                                            #initializing targ with target value
        if len(num)==0:                                                             #if num string is empty return result
            return self.result
        self.helper(num,'',0,0,0)                                                   #call resursive helper function
        return self.result                                                          #return final result
    
    def helper(self,num:List[int],path:str,calc:int,tail:int,index:int)->None:
        if index==len(num):                                                         #if the index has reached end of string  and the targest and current 
            if calc==self.targ:                                                     #calculated value are same append path to result and return
                self.result.append(path)
            return
        for i in range(index,len(num)):                                             #for i ranging between index and length od string num
            if index!=i and num[index]=='0':                                        #if index and i are ot same and 0 is encountered continue
                continue                                    
            curr=num[index:i+1]                                                     #obtain the current value being processed
            if index==0:                                                            #if the index is at zero
                self.helper(num,path+curr,int(curr),int(curr),i+1)                  #call the helper function with just the path and Current value
            else:
                self.helper(num,path+'+'+curr,calc+int(curr),int(curr),i+1)         #else call helper functions for +,- and * respectively
                self.helper(num,path+'-'+curr,calc-int(curr),-int(curr),i+1)
                self.helper(num,path+'*'+curr,calc-tail+tail*int(curr),tail*int(curr),i+1)