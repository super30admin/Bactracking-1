# TC: O(N X 4^N)
# SC: O(N X 4^N)

class Solution:
    res=[]
    def helper(self,num,target,pivot,path,calc,tail):
        if pivot==len(num) and target==calc:
            self.res.append(path)
            return

        for i in range(pivot,len(num)):
            if len(str(int(num[pivot:i+1])))==len(num[pivot:i+1]):
                cur=int(num[pivot:i+1])
                if pivot==0:
                    self.helper(num,target,i+1,str(cur),cur,cur)
                else:
                    self.helper(num,target,i+1,path+"+"+str(cur),calc+cur,cur)

                    self.helper(num,target,i+1,path+"-"+str(cur),calc-cur,-cur)

                    self.helper(num,target,i+1,path+"*"+str(cur),(calc-tail)+(tail*cur),tail*cur)

    def addOperators(self, num: str, target: int) -> List[str]:
        self.res=[]
        self.helper(num,target,0,"",0,0)
        return self.res



        