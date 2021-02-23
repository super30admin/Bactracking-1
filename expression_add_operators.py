# NOT SURE ABOUT TIME COMPLEXITY
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        return self.findExpressions(num,0,0,0,target,"",[])

    def findExpressions(self,num,index,previousSum,previousAdd,target,currentExpression,output):
        if index == len(num):
            if previousSum == target:
                output.append(currentExpression[:])
            return output
        for i in range(index,len(num)):
            if num[index] == "0" and i != index:
                continue
            
            currentNum = int(num[index:i+1])
            
            if index == 0:
                self.findExpressions(num,i+1,currentNum,currentNum,target,currentExpression+str(currentNum),output)
            else:
                self.findExpressions(num,i+1,previousSum + currentNum,currentNum,target,currentExpression+"+"+  str(currentNum),output)
                self.findExpressions(num,i+1,previousSum - currentNum,-currentNum,target,currentExpression+ "-" + str(currentNum),output)
                self.findExpressions(num,i+1,previousSum - previousAdd + previousAdd * currentNum,previousAdd * currentNum,target,currentExpression +"*" + str(currentNum),output)
      
        return output