#Time Complexity :- Exponential
#Space Complexity:- Exponential

class Solution:
    result = []
    def addOperators(self, num: str, target: int) -> List[str]:
        self.result = []
        self.helper(num,target, 0,'',0,0)
        return self.result

    def helper(self,num, target,index, path, calc, tail):
        # base
        if index == len(num):
            if calc == target:
                self.result.append(path)
                return

        # logic
        for i in range(index, len(num)):
            if index!=i and num[index]=='0':
                continue
            curr = int(float(num[index:i+1]))
            if index ==0:
                self.helper(num,target,i+1,path+str(curr),curr, curr)
            else:
                #+addOperators
                self.helper(num,target, i+1,path+'+'+str(curr), calc+curr, +curr)

                #- operator
                self.helper(num,target, i+1, path+'-'+str(curr), calc-curr, -curr)

                #* operator
                self.helper(num,target,i+1, path+'*'+str(curr), calc-tail+tail*curr  , curr*tail)