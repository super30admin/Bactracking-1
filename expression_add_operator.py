# time: O(4^N)
# space: O(N)
#leetcode: YES


#backtracking
class Solution:
    def helper(self, num, target, pivot, cal, tail):
        # base
        if(pivot==len(num)):
            if(target==cal):
                # print(self.path)
                temp="".join(list(self.path))
                # temp=(self.path+'.')[:-1]
                self.result.append(temp)
            return 
        # logic
        for i in range(pivot, len(num)):
            if(num[pivot]=='0' and i!=pivot):
                continue
            curr=int(num[pivot:i+1])
            l=len(str(curr))
            if(pivot==0):
                self.path=self.path+str(curr)
                self.helper(num, target, i+1, curr, curr)
                self.path=self.path[:len(self.path)-l]
            else:
                # +
                
                self.path=self.path+"+"+str(curr)
                self.helper(num, target, i+1, cal+curr, curr)
                self.path=self.path[:len(self.path)-l-1]
                # -
                self.path=self.path+"-"+str(curr)
                self.helper(num, target, i+1, cal-curr, curr*-1)
                self.path=self.path[:len(self.path)-l-1]
                # *
                self.path=self.path+"*"+str(curr)
                self.helper(num, target, i+1, cal-tail+tail*curr, tail*curr)
                self.path=self.path[:len(self.path)-l-1]
    def addOperators(self, num: str, target: int) -> List[str]:
        self.result=[]
        self.path=""
        self.helper(num, target, 0, 0, 0)
        return self.result
    


    #exhaustive
    class Solution:
    def helper(self, num, target, pivot, cal, tail, path):
        # base
        if(pivot==len(num)):
            if(target==cal):
                self.result.append(path)
            return 
        # logic
        for i in range(pivot, len(num)):
            if(num[pivot]=='0' and i!=pivot):
                continue
            curr=int(num[pivot:i+1])
            if(pivot==0):
                self.helper(num, target, i+1, curr, curr, path+str(curr))
            else:
                # +
                self.helper(num, target, i+1, cal+curr, curr, path+"+"+str(curr))
                # -
                self.helper(num, target, i+1, cal-curr, curr*-1, path+"-"+str(curr))
                # *
                self.helper(num, target, i+1, cal-tail+tail*curr, tail*curr, path+"*"+str(curr))

    def addOperators(self, num: str, target: int) -> List[str]:
        self.result=[]
        self.helper(num, target, 0, 0, 0, "")
        return self.result