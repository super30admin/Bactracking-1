class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.res=[]
        self.helper(num,target,0,"",0,0)
        return self.res

    def helper(self,num,target,pivot,path,calc,tail):

        if pivot==len(num) and calc==target:
            self.res.append(path)

        for i in range(pivot,len(num)):
            if i!=pivot and num[pivot] == '0':
                continue

            curr = int(num[pivot:i+1])

            if pivot == 0:
                self.helper(num, target, i+1, path + str(curr), curr, curr)
            else:
                self.helper(num, target, i+1, path + "+" + str(curr), calc + curr, curr)
                self.helper(num, target, i+1, path + "-" + str(curr), calc - curr, -curr)
                self.helper(num, target, i+1, path + "*" + str(curr), calc - tail + curr * tail, curr*tail)

