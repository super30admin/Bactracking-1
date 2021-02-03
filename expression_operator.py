# Time Complexity : O(4*n) where n is the length of input string
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I recursively go into each character in string and do one of 4 operations recusively combine, add
# subtract and multiply until I reach the target and then do the backtracking on the string

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.result = []
        self.target = target
        if len(num) == 0: return self.result
        self.helper(num, "", 0, 0, 0)
        return self.result
        
    def helper(self, num, path, calc, tail, index):
        if index == len(num):
            if calc == self.target:
                self.result.append(path)
                
            return
        
        for i in range(index, len(num)):
            if index!=i and num[index] == "0": continue;
            curr = int(num[index: i+1])
            
            if index == 0:
                self.helper(num, path+str(curr), curr, curr, i+1)
            else:
                self.helper(num, path+"+"+str(curr), calc+curr, curr, i+1)
                
                self.helper(num, path+"-"+str(curr), calc-curr, -curr, i+1)
                
                self.helper(num, path+"*"+str(curr), calc-tail+tail*curr, tail*curr, i+1)