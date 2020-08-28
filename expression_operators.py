"""
// Time Complexity : O(n*4^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : In the final stage of creating the result string
,Output is incorrect currently
// Your code here along with comments explaining your approach
Algorithm explanation
1. Break the string into n possible operands using recursive and backtracking on the operands
2. Run a recursive algo wch allows to branch into all possible operators and 
checking the evaluated output with the target at each step 

Configuration - prev_string, calc_value - value till now, 
tail_value - addon part in previous computation
1. Base case - End of the string and cal value matching the target, append the string to result
2. Iterate over the string till the end
    if the index is 0,we add no op and just move ahead in the string with prev strn, curr val and tail valu to be set for futher action
    Update the eval_string for respective operator from +,-,* 
    For + and -, we compute the eval value and tail value normally
    For nultiplication, we leverage the tail value to compute the current 
    eval value
    recurse for all 3 operator
"""
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        def helper(num,target,prev_string,calc_value,tail_value,index):
            #base case
            if index == len(num):
                if calc_value == target:
                    results.append(prev_string)
                return
            
            #logic
            for i in range(index,len(num)):
                #handling middle 0 in the number eg 105
                if index!=i and num[index] == '0':
                    break
                curr = int(num[index:i+1])
                eval_string = ""
                if index == 0: # don't choose any op
                    #action
                    eval_string = prev_string + str(curr)
                    #recurse
                    helper(num,target, eval_string,curr,curr,i+1)
                    #backtrack
                    eval_string = prev_string
                else:
                    #check for all 3 operators with * having precedence
                    tail = 0
                    for op in ['+','-','*']:
                        if op == '+':
                            #eval_value = operands[i-1] + operands[i]
                            eval_value = calc_value + curr
                            tail = curr
                        elif op == '-':
                            #eval_value = operands[i-1] - operands[i]
                            eval_value = calc_value - curr
                            tail = -curr
                        elif op == '*':
                            eval_value = calc_value - tail_value + tail_value*curr
                            #eval_value = operands[i-1] * operands[i]
                            tail = tail_value * curr
                        
                        #action
                        eval_string = prev_string + op + str(curr)
                        #recurse
                        helper(num,target, eval_string,eval_value,tail,i+1)
                        
                        #backtrack
                        eval_string = prev_string
        
        results = []
        helper(num,target,"",0,0,0)
        return results