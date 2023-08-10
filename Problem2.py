#Time Complexity :O(4^N)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.result=[]
        self.helper(num,0,target,0,0,"")
        return self.result

    def helper(self, num, pivot, target, calc, tail, path):
        #base
        if pivot==len(num):
            if target==calc:
                self.result.append(path)
            return

        #logic
        for i in range(pivot,len(num)):
            if num[pivot]=='0' and i!=pivot:
                continue
            curr=int(num[pivot:i+1])
            if pivot==0:
                self.helper(num,i+1,target,curr,curr,path+str(curr))
            else:
                self.helper(num,i+1,target,calc+curr,curr,path+"+"+str(curr))
                self.helper(num,i+1,target,calc-curr,-curr,path+"-"+str(curr))
                self.helper(num,i+1,target,calc-tail+tail*curr,tail*curr,path+"*"+str(curr))
