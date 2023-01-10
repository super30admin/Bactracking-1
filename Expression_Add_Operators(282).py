# Time Complexity: O(n*4^n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def __init__(self):
        self.result = list()

    def addOperators(self, num: str, target: int) -> List[str]:
        self.recurse(num,target,0,0,0,"")
        return self.result

    def recurse(self,num,target,index,calc,tail,path):
        # base case
        if index==len(num):
            if calc==target:
                self.result.append(path)
            return

        #for loop based recursion
        for i in range(index,len(num)):
            if index!=i and num[index]=="0":
                continue
            curr = int(num[index:i+1])
            if index==0:
                self.recurse(num,target,i+1,curr,curr,path+str(curr))
            else:
                self.recurse(num,target,i+1,calc+curr,curr,path+"+"+str(curr))
                self.recurse(num,target,i+1,calc-curr,-curr,path+"-"+str(curr))
                self.recurse(num,target,i+1,(calc-tail)+(tail*curr),tail*curr,path+"*"+str(curr))