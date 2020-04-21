"""
// Time Complexity : O(n2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : In the final stage of creating the result string
,Output is incorrect currently
// Your code here along with comments explaining your approach
Algorithm explanation
1. Break the string into n possible operands using recursive and backtracking on the operands
2. Run a recursive algo wch allows to branch into all possible operators and 
checking the evaluated output with the target at each step 

Problems
- For the test case [2,3,2], it's not considering the other path(REally thought it would)
- Handling 0 in the middle


"""
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        """
        Idea is to get the all possible combinations of the number and probably simultaneously check the current score with the target, or else backtrack to use other operator or even other operands
        1. Break the string into n possible operands and run a recursive algo wch allows to branch into all possible operators and checking the evaluated output with the target at each step 
        """
        operands = []
        result = []
        def operands_rec(num,pos,n):
            if n == pos:
                operands.append(result[::])
                return
            
            for i in range(pos,n):
                #check if result needs to be updated
                substr = num[pos:i+1]
                if substr and len(substr) < n:
                    result.append(int(substr))
                    operands_rec(num,i+1,n)
                    result.pop()
        
        self.result_string = ""
        def expression_rec(operands,i,eval_value,prev_string,target,n):
            #base case
            if eval_value and eval_value > target:
                return
            if i == n:
                if eval_value == target:
                    final_operands.append(prev_string)
                return
            
            #call the recursive functions for all three operators
            for op in ['+','-','*']:
                if op == '+':
                    #eval_value = operands[i-1] + operands[i]
                    eval_value = eval_value + operands[i]
                elif op == '-':
                    #eval_value = operands[i-1] - operands[i]
                    eval_value = eval_value - operands[i]
                elif op == '*':
                    #eval_value = operands[i-1] * operands[i]
                    eval_value = eval_value * operands[i]
                self.result_string = prev_string + op + str(operands[i])
                expression_rec(operands,i+1,eval_value,self.result_string,target,n)
                self.result_string = prev_string
        
        final_operands = []
        expression = []
        operands_rec(num,0,len(num))
        print(operands)
        for op in operands:
            expression_rec(op,1,op[0],str(op[0]),target,len(op))
        
        return final_operands