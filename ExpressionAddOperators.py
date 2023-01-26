#Time Complexity: Exponential
#Space: O(n)
#Successfully ran on leetcode
 
class Solution:
    def __init__(self):
        self.result = []
    def addOperators(self, num: str, target: int) -> List[str]:
        if num is None or len(num)==0:
            return []
        self.helper(num,target,0,0,0,"")
        return self.result
    def helper(self,num,target,index,calc,tail,path):
        #base
        if index==len(num):
            if calc==target:
                self.result.append(path)
            return
        #logic
        for i in range(index,len(num)):
            if index!=i and num[index]=='0':
                continue
            curr = int(num[index:i+1])
            if index==0:
                self.helper(num,target,i+1,curr,curr,path+str(curr))
            else:
                #add case
                self.helper(num,target,i+1,calc+curr,+curr,path+'+'+str(curr))
                #sub case
                self.helper(num,target,i+1,calc-curr,-curr,path+'-'+str(curr))
                #multiply case
                self.helper(num,target,i+1,calc-tail+tail*curr,tail*curr,path+'*'+str(curr))