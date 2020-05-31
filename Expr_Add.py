// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
we start with each character and then get all the different expressions with different lengths.
with the different expressions that we get we try to incorporate different operators(+,-,*) in between.
with every expression we see if the value of these expressions is equal to the given value.then we store this expression.

Time complexity --> o(4**N)
space complexity --> o(N**(4**N))

class Solution:
    def backtrack(self,result,num,target,index,expr,value,prev):
        print(expr)
        if index==len(num):
            if value==target:
                result.append(expr)
            return
            
        for i in range(index,len(num)):
            if index!=i and num[index]=='0':
                break
                #for example --> 1 2 3 , we start with 1,1+2,1+2+3,1+2-3,1+2*3,1-2,1-2+3 and so on.
            operand=int(num[index:i+1])
            #we start with the first character in num and add it to the expression.
            if index==0:
                self.backtrack(result,num,target,i+1,''+str(operand),operand,operand)
            else:
                #for addition
                self.backtrack(result,num,target,i+1,expr+'+'+str(operand),value+operand,operand)
                #for subtraction
                self.backtrack(result,num,target,i+1,expr+'-'+str(operand),value-operand,-operand)
                #for multiplication
                self.backtrack(result,num,target,i+1,expr+'*'+str(operand),(value-prev)+(prev*operand),prev*operand)
            
        return
    
    def addOperators(self, num: str, target: int) -> List[str]:
        result=[]
        self.backtrack(result,num,target,0,'',0,0)
        return result