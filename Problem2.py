"""
282. Expression Add Operators
Time Complexity - O(3n**n)
Space Complexity - O(3n)
Here we are using backtracking with parameters num ,target, output ,prex-sum,pre_val,path
if index is greater than or equal to len(path) and path_sum is equal to target append path to output
Start for loop starting from index to len(string) 
if index is equal to 0 that means that we are building our current_element string
and call backtracking for appending next elements
else
call +, - and * functions for backtracking"""
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.output = []
        if len(num) == 0:
            return self.output
        self.backtracking(num,target,self.output,0,0,0,"")
        return self.output
    
    def backtracking(self,num,target,output,index,pre_val,prev_number,path):
        if index >= len(num):
            if pre_val == target:
                output.append(path)
            return
        for i in range(index,len(num)):
            curr_element = num[index:i+1]
            
            if(num[index] == '0' and i != index):
                continue
            
            if index == 0:
                self.backtracking(num,target,output,i+1,int(curr_element),int(curr_element),path+curr_element)
            else:
                    # +
                self.backtracking(num,target,output,i+1,int(curr_element)+pre_val,int(curr_element),path + '+' + curr_element)
                    # -
                self.backtracking(num,target,output,i+1,pre_val-int(curr_element),-int(curr_element),path + '-' + curr_element)
                    # *
                self.backtracking(num,target,output,i+1,(pre_val-prev_number)+(prev_number * int(curr_element)),(prev_number*int(curr_element)),path+'*'+ curr_element)
                