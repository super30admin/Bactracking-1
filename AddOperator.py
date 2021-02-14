class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        '''
        Time Complexity: O(4^n)
        Space Complexity: O(n) for each output, maximum 4^n outputs, so complexity is O(n*4^n)
        '''
        if(len(num)==0):
            return []
        o = []
        def add1(num,target,index,calc,tail,path):
            if(index==len(num)):
                if(calc==target):
                    nonlocal o
                    o.append(path[:])
                return
            for i in range(index,len(num)):
                # edge case with preceeding zero
                # we will only accept if i==index (0 will be accepted but 05 will not be accepted)
                if(i>index and num[index]=="0"):
                    return
                # no operator is already covered using backtracking
                curr = int(num[index:i+1])
                
                # no operator
                if(index==0):
                    add1(num,target,i+1,curr,curr,path+str(curr))
                else:
                    # plus operator
                    add1(num,target,i+1,calc+curr,curr,path+"+"+str(curr))
                    
                    # minus operator
                    add1(num,target,i+1,calc-curr,-1*curr,path+"-"+str(curr))
                    
                    
                    # multiply operator
                    add1(num,target,i+1,calc-tail+tail*curr,tail*curr,path+"*"+str(curr))
                     
        add1(num,target,0,0,0,"")
        return o
